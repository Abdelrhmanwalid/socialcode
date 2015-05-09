package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Post;
import socialcode.model.Tutorial;
import socialcode.model.User;
import socialcode.repository.PostRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("PostService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CodeService codeService;

    @Autowired
    private TutorialService tutorialService;

    public List<Post> findByUser(User user) {
        return postRepository.findByUserId(user.getId());
    }

    public HashMap<Post, Object> getUserPosts(User user) {
        HashMap<Post, Object> userPosts = new HashMap<Post, Object>();
        List<Post> posts = findByUser(user);
        for (Post p : posts) {
            if (p.getType().equals("code")) {
                userPosts.put(p, codeService.findByPost(p));
            } else {
                Tutorial tutorial = tutorialService.findByPost(p);
                //remove HTML tags
                tutorial.setText(tutorial.getText().replaceAll("<[^>]+>", ""));
                userPosts.put(p, tutorial);
            }
        }
        return userPosts;
    }

    public Post Save(Post post) {
        postRepository.save(post);
        return post;
    }

    public List<Post> findByUsers(List<User> users) {
        if (users.size() == 0){
            // or it will throw SQL exception and/or null exception
            return new ArrayList<Post>();
        }
        return postRepository.findByUsers(users);
    }

    public Post findById(int id){
        return postRepository.findOne(id);
    }
}
