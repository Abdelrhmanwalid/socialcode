package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import socialcode.helper.PostTypes;
import socialcode.model.*;
import socialcode.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    ImageService imageService;


    @RequestMapping(value = "/user/{$id}", method = RequestMethod.GET)
    public ModelAndView user(@PathVariable("$id") int id, ModelMap modelMap) {
        if (userService.getCurrentUser() == userService.findById(id)) {
            return new ModelAndView("redirect:/profile");
        }
        User user = userService.findById(id);
        modelMap = createUserModelMap(user, modelMap, false);

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
        User currentUser = userService.getCurrentUser();
        List<Post> favPosts = postService.findFavoritesByUser(user);
        List<Tutorial> favs = new ArrayList<Tutorial>();
        for (Post post : favPosts){
            if (post.getType().equals(PostTypes.TOUTRIAL.toString())){
                favs.add(tutorialService.findByPost(post));
            }
        }
        modelMap.addAttribute("favs", favs);
        modelMap.addAttribute("currentUser", currentUser);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("tutorials", tutorials);
        modelMap.addAttribute("codes", codes);
        modelMap.addAttribute("isCurrent", current);
        return modelMap;
    }

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

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account(ModelMap modelMap) {
        User currentUser = userService.getCurrentUser();
        modelMap.addAttribute("user", currentUser);
        return new ModelAndView("account");
    }

    @RequestMapping(value = "/account/password", method = RequestMethod.POST)
    public ModelAndView updatePassword(@Valid @ModelAttribute("user") User user, final BindingResult binding, HttpServletRequest request) {

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
        } else if (user.getPassword().length() < 6) {
            binding.addError(new FieldError(
                    "password",
                    "password",
                    "password length must be 6 chars at least"
            ));
        } else if (user.getPassword().length() > 30) {
            binding.addError(new FieldError(
                    "password",
                    "password",
                    "password Is too long to remember"
            ));
        }

        if (binding.hasErrors()) {
            return new ModelAndView("account");
        }
        user = userService.updatePassword(user);
        userService.save(user);
        return new ModelAndView("redirect:/account");
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ModelAndView updateAccount(@Valid @ModelAttribute("user") User user, final BindingResult binding,
                                      @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
            throws IOException {

        Image image;
        if (file.getSize() > 0) {
            String path = request.getSession().getServletContext().getRealPath("");
            image = imageService.save(file, path);

        } else {
            image = userService.findById(user.getId()).getProfilePicture();
        }
        user.setProfilePicture(image);
        user = userService.updateUser(user);

        if (binding.hasErrors()) {
            return new ModelAndView("account");
        }

        userService.save(user);
        return new ModelAndView("redirect:/account");
    }

}
