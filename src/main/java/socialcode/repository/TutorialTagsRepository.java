package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.TutorialTags;

@Repository("TutorialTagsRepository")
public interface TutorialTagsRepository extends JpaRepository<TutorialTags, Integer> {
}
