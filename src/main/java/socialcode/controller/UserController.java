package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import socialcode.model.Code;
import socialcode.model.Post;
import socialcode.model.Tutorial;
import socialcode.model.User;
import socialcode.service.CodeService;
import socialcode.service.PostService;
import socialcode.service.TutorialService;
import socialcode.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CodeService codeService;
    @Autowired
    PostService postService;
    @Autowired
    TutorialService tutorialService;


    @RequestMapping(value = "/profile")
    public ModelAndView profile(ModelMap modelMap) {
        User user = userService.getCurrentUser();
        modelMap = createUserModelMap(user, modelMap, true);

        List<Post> postsList = postService.findByUser(user);
        HashMap<Post, Object> postsWithData = postService.getUserPosts(user);
        modelMap.addAttribute("postsList", postsList);
        modelMap.addAttribute("PostsWithData", postsWithData);

        return new ModelAndView("profile").addObject("navColor", "profile");
    }

    @RequestMapping(value = "/user/{$id}", method = RequestMethod.GET)
    public ModelAndView user(@PathVariable("$id") int id, ModelMap modelMap) {
        if (userService.getCurrentUser() == userService.findById(id)) {
            return new ModelAndView("redirect:/profile");
        }
        User user = userService.findById(id);
        User currentUser = userService.getCurrentUser();
        modelMap = createUserModelMap(user, modelMap, false);
        modelMap.addAttribute("currentUser", currentUser);

        List<Post> postsList = postService.findByUser(user);
        HashMap<Post, Object> postsWithData = postService.getUserPosts(user);
        modelMap.addAttribute("postsList", postsList);
        modelMap.addAttribute("PostsWithData", postsWithData);

        return new ModelAndView("profile").addObject("navColor", "profile");
    }

    @RequestMapping(value = "/user/{id}/follow")
    public ModelAndView follow(@PathVariable("id") int id) {
        User targetUser = userService.findById(id);
        User current = userService.getCurrentUser();
        userService.addFollower(targetUser, current);
        return new ModelAndView("redirect:/user/" + id);
    }

    @RequestMapping(value = "/user/{id}/unfollow")
    public ModelAndView unFollow(@PathVariable("id") int id) {
        User targetUser = userService.findById(id);
        User current = userService.getCurrentUser();
        userService.removeFollower(targetUser, current);
        return new ModelAndView("redirect:/user/" + id);
    }

    ModelMap createUserModelMap(User user, ModelMap modelMap, boolean current) {
        List<Code> codes = codeService.findByUSer(user);
        List<Tutorial> tutorials = tutorialService.findByUser(user);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("tutorials", tutorials);
        modelMap.addAttribute("codes", codes);
        modelMap.addAttribute("isCurrent", current);
        return modelMap;
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account(ModelMap modelMap) {
        User currentUser = userService.getCurrentUser();
        modelMap.addAttribute("user", currentUser);
        return new ModelAndView("account");
    }

    @RequestMapping(value = {"/account/password", "/account"}, method = RequestMethod.POST)
    public ModelAndView updateAccount(@Valid @ModelAttribute("user") User user, final BindingResult binding, HttpServletRequest request) {

        if (request.getRequestURI().equals("/account/password")) {
            String oldPassword = request.getParameter("oldpassword");
//        Security-context.xml -> password-encoder
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        oldPassword = bCryptPasswordEncoder.encode(oldPassword);
            if (!userService.checkPassword(user, oldPassword)) {
                binding.addError(new FieldError(
                        "password",
                        "password",
                        "The Old password is incorrect"
                ));
            } else if (user.getPassword().equals(oldPassword)) {
                binding.addError(new FieldError(
                        "password",
                        "password",
                        "the new Password is the same as the old one, why change?"
                ));
            }
        }
        if (binding.hasErrors()) {
            return new ModelAndView("account");
        }
        String password = user.getPassword();
        user = userService.findById(user.getId());
        user.setPassword(password);
        userService.save(user);
        return new ModelAndView("account");
    }

}
