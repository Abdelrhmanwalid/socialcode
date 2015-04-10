package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.Tag;

@Repository("tagRepository")
public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("select t from Tag t where t.tag = ?1")
    Tag findByTag(String tag);
}
