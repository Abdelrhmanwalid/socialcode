package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.helper.PostTypes;
import socialcode.model.Code;
import socialcode.model.Post;
import socialcode.model.User;
import socialcode.repository.CodeRepository;

import java.util.List;

@Service("CodeService")
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepository codeRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    public Code save(Code code) {
        User user = userService.getCurrentUser();
        code.setUser(user);
        if (code.isOnProfile()) {
            Post post = new Post();
            post.setType(PostTypes.CODE.toString());
            post.setUser(user);
            postService.Save(post);
            code.setPost(post);
        }
        if (code.isRunnable()) {
            // TODO : move run here from controller
        }
        codeRepository.save(code);
        return code;
    }

    public Code findById(int id) {
        return codeRepository.findOne(id);
    }

    public Code fork(int id) {
        Code code, parent;
        parent = findById(id);
        code = parent;
        code.setParent(parent);
        System.out.print("service  ");
        System.out.println(code.getParent().getId());
        return code;
    }

    @Override
    public Code findByPost(Post post) {
        return codeRepository.findByPost(post);
    }

    public int numberOfForks(Code code) {
        return codeRepository.numberOfForks(code);
    }

    public List<Code> findForks(Code code) {
        return codeRepository.findForks(code);
    }

    public List<Code> findByUSer(User user) {
        return codeRepository.findByUser(user);
    }
}
