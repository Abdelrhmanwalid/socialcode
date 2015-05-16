package socialcode.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import socialcode.model.Tutorial;
//import socialcode.service.TagService;
//import socialcode.service.TutorialService;
//import socialcode.service.TutorialTagsService;
//
//import java.util.List;
//

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
//    @Autowired
//    TutorialService tutorialService;
//    @Autowired
//    TagService tagService;
//    @Autowired
//    TutorialTagsService tutorialTagsService;
//
//
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(ModelMap modelMap,
                                    @RequestParam(value = "q", required = true) String searchText) {
//        tutorialService.indexTutorials();
//        List<Tutorial> tutorials = tutorialService.findByText(searchText);
//        for (Tutorial tutorial:tutorials){
//            tutorial.setText(tutorial.getText().replaceAll("<[^>]+>", ""));
//        }
//        modelMap.addAttribute("tutorials", tutorials);
        ModelAndView modelView = new ModelAndView("search");
        return modelView;
    }

}
