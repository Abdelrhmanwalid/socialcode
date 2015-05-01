package socialcode.service;

import socialcode.model.Code;
import socialcode.model.Post;
import socialcode.model.User;

import java.util.List;

public interface CodeService {

    Code save(Code code);
    Code findById(int id);
    Code fork(int id);
    Code findByPost(Post post);
    int numberOfForks(Code code);
    List<Code> findForks(Code code);
    List<Code> findByUSer(User user);
}
