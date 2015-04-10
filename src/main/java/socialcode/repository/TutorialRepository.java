package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.Tutorial;

@Repository("tutorialRepository")
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
}
