package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Post;
import socialcode.repository.PostRepository;

@Service("PostService")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    public Post Save(Post post) {
        postRepository.save(post);
        return post;
    }
}
