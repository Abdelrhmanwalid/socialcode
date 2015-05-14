package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Tag;
import socialcode.model.Tutorial;
import socialcode.model.TutorialTags;
import socialcode.repository.TutorialTagsRepository;

import java.util.List;

@Service("TutorialTagsService")
public class TutorialTagsServiceImpl implements TutorialTagsService {

    @Autowired
    private TutorialTagsRepository tutorialTagsRepository;

    public TutorialTags save(TutorialTags tutorialTags) {
        tutorialTagsRepository.save(tutorialTags);
        return tutorialTags;
    }

    public void save(Tutorial tutorial, Tag tag){
        TutorialTags tutorialTags = new TutorialTags();
        tutorialTags.setTag(tag);
        tutorialTags.setTutorial(tutorial);
        save(tutorialTags);
    }

    public List<Tag> findTagByTutorial(Tutorial tutorial){
        return tutorialTagsRepository.findTagByTutorial(tutorial);
    }

    public List<Tutorial> findTutorialByTag(Tag tag){
        return tutorialTagsRepository.findTutorialByTag(tag);
    }
}
