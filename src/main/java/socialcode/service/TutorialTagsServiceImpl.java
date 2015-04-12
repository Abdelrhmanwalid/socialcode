package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.TutorialTags;
import socialcode.repository.TutorialTagsRepository;

@Service("TutorialTagsService")
public class TutorialTagsServiceImpl implements TutorialTagsService {

    @Autowired
    private TutorialTagsRepository tutorialTagsRepository;

    public TutorialTags save(TutorialTags tutorialTags) {
        tutorialTagsRepository.save(tutorialTags);
        return tutorialTags;
    }
}
