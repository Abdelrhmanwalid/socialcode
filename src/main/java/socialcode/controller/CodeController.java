package socialcode.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import socialcode.AppConfig;
import socialcode.helper.ProgramingLanguages;
import socialcode.ideone.api.service.RunCodeThread;
import socialcode.model.Code;
import socialcode.service.CodeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.transform.sax.SAXSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(!modelMap.containsAttribute("code")){
            modelMap.addAttribute("code", new Code());
        }
        modelMap.addAttribute("languages", languages);
		ModelAndView modelView = new ModelAndView("codeNew");
		modelView.addObject("navColor", "code");
		return modelView;

	}

	@RequestMapping(value = "newCode", method = RequestMethod.POST)
	public ModelAndView addNewCode(@Valid @ModelAttribute("code") Code code,final BindingResult binding,RedirectAttributes redirectAttributes) {
        if(binding.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.code", binding);
            redirectAttributes.addFlashAttribute("code", code);
            return new ModelAndView("redirect:/newCode");
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
		return new ModelAndView( "redirect:" + codePage);

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
		return new ModelAndView("codes").addObject("navColor", "code");
	}

	@RequestMapping(value = "code/{$id}")
	public ModelAndView viewCode(@PathVariable("$id") int id, ModelMap modelMap) {
		Code code;
		code = codeService.findById(id);
		int numberOfForks = codeService.numberOfForks(code);
		modelMap.addAttribute("code", code);
		modelMap.addAttribute("forks", numberOfForks);
		return new ModelAndView("code").addObject("navColor", "code");
	}

	@ResponseBody
	@RequestMapping(value = "code/embed")
	public String embed(HttpServletResponse response,
			@RequestParam(value = "url", required = false) String url) {

		// not the perfect way but i was in a hurry.
		int id = Integer.parseInt(url.substring(
				url.indexOf("e/", url.indexOf("/code/")) + 2,
				(url.charAt(url.length() - 1) == '/') ? url.length() - 1 : url
						.length()));
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = "";

			Map<String, String> map = new HashMap<String, String>();
			map.put("id", "");

			//remove "/
			// " from src to work for you
			map.put("html", "<iframe src=\"/socialcode/code/embedjs/"
							+id + "\" frameborder=\"0\" scrolling=\"no\" "
							+" width=\"100%\" onload='resizeIframe(this)' frameborder=\"0\""
							+ "style=\"border: 1px solid #c0c0c0;"
							+ " overflow-x: hidden;\">"
							+ "</iframe>");

			json = mapper.writeValueAsString(map);
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
			System.out.println(json);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "code/embedjs/{$id}")
	@ResponseBody
	public String embedjs(@PathVariable("$id") int id,HttpServletRequest request) {
		Code code;
		code = codeService.findById(id);
		String path = request.getContextPath();
		String embed = "<link rel=\"stylesheet\" href=\""+path+"/assets/css/highlight.min.css\" >"
				+ "<html><body style=\"margin:0px;\" > <pre "
				+ "style=\"border-radius: 0px;margin: 0px; border: 0px none; font-size: 13px; white-space: normal; padding: 40px 50px; background: none repeat scroll 0% 0% rgb(35, 36, 31); word-wrap: normal;\"  >"
				+ "<code class=\"" + code.getLanguage() + "\">"
				+ org.springframework.web.util.HtmlUtils.htmlEscape(code.getCode()).replaceAll("(\r\n|\n)", "<br/>") + "</code></pre>"
						+ "<script src=\""+path+"/assets/js/highlight.min.js\"></script>"
						+ "<script>hljs.initHighlightingOnLoad();</script></body></html>";
		return embed;
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

	@RequestMapping(value = "code/{id}/forks", method = RequestMethod.GET)
	public ModelAndView findForks(ModelMap modelMap, @PathVariable("id") int id){
		Code code = codeService.findById(id);
		List<Code> forks = codeService.findForks(code);
		modelMap.addAttribute("code", code);
		modelMap.addAttribute("forks", forks);
		modelMap.addAttribute("isForkPage", true);
		return new ModelAndView("codes").addObject("navColor", "code");
	}
}
