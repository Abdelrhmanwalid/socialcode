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

@Service("TutorialService")
public class TutorialServiceImpl implements TutorialService {

	@Autowired
	private TutorialRepository tutorialRepository;
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
}
