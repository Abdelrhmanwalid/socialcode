package socialcode.service;


import socialcode.model.User;

public interface UserService {

    User save(User user);

    User findByUserEmail(String email);

    public User getCurrentUser();
}
