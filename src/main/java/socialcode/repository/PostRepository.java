package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.Post;

import java.util.List;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p where p.user.id = ?1")
    List<Post> findByUserId(int id);

//    @Query("select t from Tutorial t where ?1 in t.tags")
//    List<Post> findByTag(String tag);
}
