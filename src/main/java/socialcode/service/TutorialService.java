package socialcode.service;

import socialcode.model.Code;
import socialcode.model.Tutorial;

public interface TutorialService {
    Tutorial save(Tutorial tutorial);
    Tutorial findById(int id);
}
