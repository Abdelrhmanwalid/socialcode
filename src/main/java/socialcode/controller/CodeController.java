package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.AppConfig;
import socialcode.helper.ProgramingLanguages;
import socialcode.ideone.api.service.RunCodeThread;
import socialcode.model.Code;
import socialcode.model.User;
import socialcode.service.CodeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeController {

	@Autowired
	CodeService codeService;

	@RequestMapping(value = "/newCode", method = RequestMethod.GET)
	public ModelAndView newCode(ModelMap modelMap) {

		List<String> languages = new ArrayList<String>();
		for (ProgramingLanguages lang : ProgramingLanguages.values()) {
			languages.add(lang.toString());
		}

		modelMap.addAttribute("languages", languages);
		modelMap.addAttribute("code", new Code());
		ModelAndView modelView = new ModelAndView("codeNew");
		modelView.addObject("navColor", "code");
		return modelView;

	}

	@RequestMapping(value = "newCode", method = RequestMethod.POST)
	public String addNewCode(@ModelAttribute("code") Code code) {
		codeService.save(code);

		if (code.isRunnable()) {
			ApplicationContext context = new AnnotationConfigApplicationContext(
					AppConfig.class);
			ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context
					.getBean("codeExecutor");
			RunCodeThread runCode = (RunCodeThread) context
					.getBean("runCodeThread");
			runCode.setCode(code);
			runCode.setCodeService(codeService);
			runCode.setLang(new socialcode.ideone.api.service.Ideone()
					.getLanguageIdByName(code.getLanguage()));
			runCode.setSource(code.getCode());
			runCode.setInput(code.getInput());
			taskExecutor.execute(runCode);
		}

		int id = code.getId();
		String codePage = "/code/" + id;
		return "redirect:" + codePage;

	}


	@RequestMapping(value = "code/{$id}/fork", method = RequestMethod.POST)
	public String fork(@ModelAttribute("code") Code code, @PathVariable("$id") int parent_id) {
		if (parent_id != 0) {
			Code parent = codeService.findById(parent_id);
			code.setParent(parent);
		}
		codeService.save(code);

		if (code.isRunnable()) {
			ApplicationContext context = new AnnotationConfigApplicationContext(
					AppConfig.class);
			ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) context
					.getBean("codeExecutor");
			RunCodeThread runCode = (RunCodeThread) context
					.getBean("runCodeThread");
			runCode.setCode(code);
			runCode.setCodeService(codeService);
			runCode.setLang(new socialcode.ideone.api.service.Ideone()
					.getLanguageIdByName(code.getLanguage()));
			runCode.setSource(code.getCode());
			runCode.setInput(code.getInput());
			taskExecutor.execute(runCode);
		}

		int id = code.getId();
		String codePage = "/code/" + id;
		return "redirect:" + codePage;

	}

	@RequestMapping(value = "code")
	public ModelAndView codes() {
		return new ModelAndView("codes").addObject("navColor","code");
	}
	
	@RequestMapping(value = "code/{$id}")
	public ModelAndView viewCode(@PathVariable("$id") int id, ModelMap modelMap) {
		// TODO : get code form database and send it back to the view
		Code code;
		User user;
		code = codeService.findById(id);
		user = code.getUser();
		modelMap.addAttribute("code", code);
		modelMap.addAttribute("user", user);
		// temporarily redirect to new code page until view code page is ready
		return new ModelAndView("code").addObject("navColor","code");
	}
	@RequestMapping(value = "code/{$id}/fork", method = RequestMethod.GET)
	public ModelAndView codeFork(@PathVariable("$id") int id, ModelMap modelMap) {
		Code code = codeService.fork(id);
		List<String> languages = new ArrayList<String>();
		languages.add(code.getLanguage());
		modelMap.addAttribute("code", code);
		modelMap.addAttribute("parent_id", code.getParent().getId());
		modelMap.addAttribute("languages", languages);
		return new ModelAndView("codeNew").addObject("navColor","code");
	}
}
