package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socialcode.model.User;
import socialcode.repository.UserRepository;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User findByUserEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Transactional
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            return findByUserEmail(username);
        }
        return null;
    }

    @Transactional
    public User findById(int id){
        return userRepository.findOne(id);
    }

    @Transactional
    public boolean addFollower(User user, User follower){
        List<User> followers = user.getFollowers();
        boolean success = followers.add(follower);
        user.setFollowers(followers);
        save(user);
        return success;
    }

    @Transactional
    public boolean removeFollower(User user, User follower){
        List<User> followers = user.getFollowers();
        boolean success = followers.remove(follower);
        user.setFollowers(followers);
        save(user);
        return success;
    }

    @Transactional
    public List<User> findFollowings(User user) {
        return userRepository.findFollowing(user);
    }

    public boolean checkPassword(User user, String password){
        User u = findById(user.getId());
        return u.getPassword().equals(password);
    }

    @Transactional
    public User updatePassword(User user){
        User u = findById(user.getId());
        u.setPassword(user.getPassword());
        return u;
    }

    @Transactional
    public User updateUser(User user){
        User u = findById(user.getId());
        u.setFirst_name(user.getFirst_name());
        u.setLast_name(user.getLast_name());
        u.setBiography(user.getBiography());
        u.setProfilePicture(user.getProfilePicture());
        return u;
    }
}
