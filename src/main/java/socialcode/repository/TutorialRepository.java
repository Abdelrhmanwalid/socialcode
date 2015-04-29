package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.Tutorial;
import socialcode.model.User;

import java.util.List;

@Repository("TutorialRepository")
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    @Query("select t from Tutorial t where t.post.user = ?1")
    List<Tutorial> findByUser(User user);
}
