package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import socialcode.helper.PostTypes;
import socialcode.model.Post;
import socialcode.model.Tutorial;
import socialcode.model.User;
import socialcode.repository.TutorialRepository;
//import socialcode.repository.TutorialSearchRepository;

import java.util.ArrayList;
import java.util.List;

@Service("TutorialService")
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;
//    @Autowired
//    private TutorialSearchRepository tutorialSearchRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;

	public Tutorial save(Tutorial tutorial) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication != null) {
			String username = authentication.getName();
			User user = userService.findByUserEmail(username);
			Post post = new Post();
			post.setType(PostTypes.TOUTRIAL.toString());
			post.setUser(user);
			postService.Save(post);
			tutorial.setPost(post);
		}
		tutorialRepository.save(tutorial);
		return tutorial;
	}

	public Tutorial findById(int id) {
		return tutorialRepository.findOne(id);
	}

	public List<Tutorial> findByUser(User user) {
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		tutorials = tutorialRepository.findByUser(user);
		return tutorials;
	}

	public Tutorial findByPost(Post post) {
		return tutorialRepository.findByPost(post);
	}

//    public void indexTutorials() {
//        tutorialSearchRepository.indexTutorials();
//    }

//    public List<Tutorial> findByText(String text) {
//        List<Tutorial> tutorials = tutorialSearchRepository.search(text);
//        return tutorials;
//    }
}
