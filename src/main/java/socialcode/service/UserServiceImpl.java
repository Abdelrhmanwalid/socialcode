package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socialcode.model.User;
import socialcode.repository.UserRepository;

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

    public User getCurrentUser(){
        User activeUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return activeUser;
    }
}
