package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.Tag;
import socialcode.model.Tutorial;
import socialcode.model.TutorialTags;

import java.util.List;

@Repository("TutorialTagsRepository")
public interface TutorialTagsRepository extends JpaRepository<TutorialTags, Integer> {
    @Query("select t.tag from TutorialTags t where t.tutorial = ?1")
    List<Tag> findTagByTutorial(Tutorial tutorial);

    @Query("select t.tutorial from TutorialTags t where t.tag = ?1")
    List<Tutorial> findTutorialByTag(Tag tag);
}
