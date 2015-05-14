package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.Post;
import socialcode.model.User;
import socialcode.service.PostService;
import socialcode.service.UserService;

import java.util.HashMap;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	@Autowired
	PostService postService;

	@RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	public ModelAndView handleRequest(ModelMap modelMap) {
		User currentUser = userService.getCurrentUser();
		List<User> userFollowing = userService.findFollowings(currentUser);
		List<Post> postsList = postService.findByUsers(userFollowing);
		HashMap<Post, Object> postsWithData = new HashMap<Post, Object>();
		for (User u : userFollowing) {
			postsWithData.putAll(postService.getUserPosts(u));
		}

		modelMap.addAttribute("postsList", postsList);
		modelMap.addAttribute("PostsWithData", postsWithData);
		modelMap.addAttribute("currentUser", currentUser);

		return new ModelAndView("home").addObject("navColor","home");
	}

}