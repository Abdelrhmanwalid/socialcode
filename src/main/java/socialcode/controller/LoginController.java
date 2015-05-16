package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.User;
import socialcode.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		return ("loginNregister");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView RegisterUser(@Valid @ModelAttribute("user")User user,final BindingResult binding) {

        if(binding.hasErrors()) {
            return new ModelAndView("loginNregister");
        }
//		Security-context.xml -> password-encoder
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.save(user);
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