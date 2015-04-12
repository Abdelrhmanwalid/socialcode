package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import socialcode.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/profile")
    public ModelAndView profile(){
        return new ModelAndView("profile");
    }

    @RequestMapping(value = "/user/{$id}")
    public ModelAndView user(@PathVariable("$id") int id){
        // TODO : get user from database and send it back to the view
        return new ModelAndView("user");
    }
}
