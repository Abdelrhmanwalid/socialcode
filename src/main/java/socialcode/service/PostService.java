package socialcode.service;

import socialcode.model.Post;
import socialcode.model.User;

import java.util.HashMap;
import java.util.List;

public interface PostService {
    List<Post> findByUser(User user);
    HashMap<Post, Object> getUserPosts(User user);
    Post Save(Post post);
    List<Post> findByUsers(List<User> users);
    Post findById(int id);
    void favorite(Post post, User user);
    void unfavorite(Post post, User user);
    List<User> findFavoritesByUser(User user);
}
