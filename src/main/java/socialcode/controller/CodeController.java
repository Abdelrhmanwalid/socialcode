package socialcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CodeController {

	@RequestMapping(value = "newCode", method = RequestMethod.GET)
	public ModelAndView newCode(ModelMap modelMap) {

		ModelAndView modelView = new ModelAndView("codeNew");
		modelView.addObject("navColor", "code");
		return modelView;

	}

	@RequestMapping(value = "code/{$id}")
	public String code(@PathVariable("$id") String $id) {
		// TODO : get code form database and send it back to the view
		return "code";
	}
}
