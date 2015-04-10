package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.ToutrialTags;

@Repository("tutorialTagsRepository")
public interface TutorialTagsRepository extends JpaRepository<ToutrialTags, Integer> {
}
