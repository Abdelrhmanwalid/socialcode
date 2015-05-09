package socialcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import socialcode.model.Post;
import socialcode.model.User;
import socialcode.service.FavoriteService;
import socialcode.service.PostService;
import socialcode.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FavoriteController {

    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    FavoriteService favoriteService;

    @RequestMapping(value = "/tutorial/{id}/favorite")
    public String favorite(@PathVariable("id") int id, HttpServletRequest request) {
        Post post = postService.findById(id);
        User user = userService.getCurrentUser();
        favoriteService.save(favoriteService.add(user, post));
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

}
