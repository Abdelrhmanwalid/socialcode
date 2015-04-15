package socialcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TutorialController {

    @RequestMapping(value = "/newTutorial")
    public ModelAndView newTutorial(ModelMap modelMap){
        return new ModelAndView("tutorialNew");
    }

    @RequestMapping(value = "tutorial/{$id}")
    public ModelAndView tutorial(@PathVariable("$id") int id){
        return new ModelAndView("tutorial");
    }

}
