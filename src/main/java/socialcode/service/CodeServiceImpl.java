package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import socialcode.helper.PostTypes;
import socialcode.model.Code;
import socialcode.model.Post;
import socialcode.model.User;
import socialcode.repository.CodeRepository;

@Service("CodeService")
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private UserService userService;

    public Code save(Code code) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.findByUserEmail(username);
        code.setUser(user);
        if (code.isOnProfile()){
            Post post = new Post();
            post.setType(PostTypes.CODE.toString());
            post.setUser(user);
        } if (code.isRunnable()) {
            // TODO : move run here from controller
        }
        codeRepository.save(code);
        return code;
    }

    public Code findById(int id) {
        return codeRepository.findOne(id);
    }

}
