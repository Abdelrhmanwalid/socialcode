package socialcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

    @RequestMapping(value = "newCode")
    public String newCode(ModelMap modelMap){
        return "newCode";
    }

    @RequestMapping(value = "code/{$id}")
    public String code(@PathVariable("$id") String $id){
        // TODO : get code form database and send it back to the view
        return "code";
    }
}
