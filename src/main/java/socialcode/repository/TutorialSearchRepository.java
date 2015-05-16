package socialcode.repository;

import socialcode.model.Tutorial;

import java.util.List;


public interface TutorialSearchRepository {
    void indexTutorials();
    public List<Tutorial> search(String text) ;
}
