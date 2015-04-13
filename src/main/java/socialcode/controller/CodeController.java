package socialcode.controller;

import java.util.ArrayList;
import java.util.List;

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
import socialcode.service.CodeService;

@Controller
public class CodeController {

	@Autowired
	CodeService codeService;

	@RequestMapping(value = "newCode", method = RequestMethod.GET)
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

	@RequestMapping(value = "code/{$id}")
	public String code(@PathVariable("$id") String id) {
		// TODO : get code form database and send it back to the view
		// temporarily redirect to new code page until view code page is ready
		return "redirect:/newCode";
	}
}
