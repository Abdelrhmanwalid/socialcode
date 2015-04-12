package socialcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TutorialController {

    @RequestMapping(value = "/newTutorial")
    public String newTutorial(ModelMap modelMap){
        return "newTutorial";
    }

    @RequestMapping(value = "tutorial/{$id}")
    public String tutorial(@PathVariable("$id") String $id){
        return "tutorial";
    }

}
