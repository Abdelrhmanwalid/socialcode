package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.User;
import socialcode.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("user")User user) {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegisterUser(@ModelAttribute("user")User user) {
//		Security-context.xml -> password-encoder
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.save(user);
		System.out.println("controller save");
		return new ModelAndView("redirect:home");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityContextHolder.clearContext();
		return "redirect:login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView Register(@ModelAttribute("user")User user){
		
		return new ModelAndView("register");
	}
}