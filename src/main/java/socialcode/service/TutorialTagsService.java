package socialcode.service;

import socialcode.model.Tag;
import socialcode.model.Tutorial;
import socialcode.model.TutorialTags;

import java.util.List;

public interface TutorialTagsService {
    TutorialTags save(TutorialTags tutorialTags);
    void save(Tutorial tutorial, Tag tag);
    List<Tag> findTagByTutorial(Tutorial tutorial);
    List<Tutorial> findTutorialByTag(Tag tag);
}
