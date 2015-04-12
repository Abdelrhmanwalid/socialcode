package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.helper.ProgramingLanguages;
import socialcode.model.Code;
import socialcode.service.CodeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeController {

	@Autowired
	CodeService codeService;

	@RequestMapping(value = "newCode", method = RequestMethod.GET)
	public ModelAndView newCode(ModelMap modelMap) {

		List<String> languages = new ArrayList<String>();
		for (ProgramingLanguages lang : ProgramingLanguages.values()){
			languages.add(lang.toString());
		}

		modelMap.addAttribute("languages", languages);
		modelMap.addAttribute("code", new Code());
		ModelAndView modelView = new ModelAndView("codeNew");
		modelView.addObject("navColor", "code");
		return modelView;

	}


	@RequestMapping(value = "newCode", method = RequestMethod.POST)
	public String addNewCode(@ModelAttribute("code")Code code) {
		codeService.save(code);
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
