package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import socialcode.model.Code;
import socialcode.model.Tutorial;
import socialcode.service.TutorialService;

@Controller
public class TutorialController {

	@Autowired
	TutorialService tutorialService;

	@RequestMapping(value = "/newTutorial", method = RequestMethod.GET)
	public ModelAndView newTutorial(ModelMap modelMap) {
		modelMap.addAttribute("tutorial", new Tutorial());
		ModelAndView modelView = new ModelAndView("tutorialNew");
		modelView.addObject("navColor", "tutorial");
		return modelView;
	}

	@RequestMapping(value = "/newTutorial", method = RequestMethod.POST)
	public String addNewCode(@ModelAttribute("tutorial") Tutorial tutorial) {
		System.out.println(tutorial.getText());
		tutorialService.save(tutorial);
		int id = tutorial.getId();
		String tutorialPage = "/tutorial/" + id;
		return "redirect:" + tutorialPage;
	}

	@RequestMapping(value = "tutorial/{$id}", method = RequestMethod.GET)
	public ModelAndView tutorial(@PathVariable("$id") int id, ModelMap modelMap) {
		Tutorial tutorial;
		tutorial = tutorialService.findById(id);
		modelMap.addAttribute("tutorial", tutorial);
		return new ModelAndView("tutorial").addObject("navColor", "tutorial");
	}

}
