package socialcode.service;

import socialcode.model.Tutorial;
import socialcode.model.User;

import java.util.List;

public interface TutorialService {
    Tutorial save(Tutorial tutorial);
    Tutorial findById(int id);
    List<Tutorial> findByUser(User user);
}
