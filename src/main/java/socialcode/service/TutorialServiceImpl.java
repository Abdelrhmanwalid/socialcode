package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Tutorial;
import socialcode.repository.TutorialRepository;

@Service("TutorialService")
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Tutorial save(Tutorial tutorial) {
        tutorialRepository.save(tutorial);
        return tutorial;
    }
}
