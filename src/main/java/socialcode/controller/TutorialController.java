package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.Tag;
import socialcode.model.Tutorial;
import socialcode.model.User;
import socialcode.service.TagService;
import socialcode.service.TutorialService;
import socialcode.service.TutorialTagsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class TutorialController {

	@Autowired
	TutorialService tutorialService;
	@Autowired
	TagService tagService;
	@Autowired
	TutorialTagsService tutorialTagsService;

	@RequestMapping(value = "/newTutorial", method = RequestMethod.GET)
	public ModelAndView newTutorial(ModelMap modelMap) {
		modelMap.addAttribute("tutorial", new Tutorial());
		ModelAndView modelView = new ModelAndView("tutorialNew");
		modelView.addObject("navColor", "tutorial");
		return modelView;
	}

	@RequestMapping(value = "/newTutorial", method = RequestMethod.POST)
	public String addNewCode(@ModelAttribute("tutorial") Tutorial tutorial, HttpServletRequest request) {
		String s = request.getParameter("tags");
		List<String> tagsStr = Arrays.asList(s.split("\\s*,\\s*"));
		List<Tag> tags = tagService.save(tagsStr);
		tutorialService.save(tutorial);
		for (Tag tag : tags){
			tutorialTagsService.save(tutorial, tag);
		}
		int id = tutorial.getId();
		String tutorialPage = "/tutorial/" + id;
		return "redirect:" + tutorialPage;
	}

	@RequestMapping(value = "tutorial/{$id}", method = RequestMethod.GET)
	public ModelAndView tutorial(@PathVariable("$id") int id, ModelMap modelMap) {
		Tutorial tutorial;
		tutorial = tutorialService.findById(id);
		User user = tutorial.getPost().getUser();
		List<Tag> tags = tutorialTagsService.findByTagTutorial(tutorial);
		modelMap.addAttribute("tags", tags);
		modelMap.addAttribute("user", user);
		modelMap.addAttribute("tutorial", tutorial);
		return new ModelAndView("tutorial").addObject("navColor", "tutorial");
	}

}
