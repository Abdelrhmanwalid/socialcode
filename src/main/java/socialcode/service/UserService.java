package socialcode.service;


import socialcode.model.User;

public interface UserService {

    User save(User user);

    User findByUserEmail(String email);

    User getCurrentUser();

    User findById(int id);

    boolean addFollower(User user, User follower);

    boolean removeFollower(User user, User follower);
}
