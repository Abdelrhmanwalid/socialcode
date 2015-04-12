package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import socialcode.model.User;
import socialcode.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("user")User user) {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String RegisterUser(@ModelAttribute("user")User user) {
		userService.save(user);
		System.out.println("controller save");
		return "home";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityContextHolder.clearContext();
		return "redirect:login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String Register(ModelMap modelMap){
		return "register";
	}
}