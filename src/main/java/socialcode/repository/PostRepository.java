package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.Post;
import socialcode.model.User;

import java.util.List;

@Repository("PostRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p where p.user.id = ?1 order by p.id desc")
    List<Post> findByUserId(int id);

    @Query("select p from Post p where p.user in ?1 order by p.id desc")
    List<Post> findByUsers(List<User> users);

    @Query("select p from Post p where ?1 member p.favoritedBy")
    List<User> findFavoritesByUser(User user);

//    @Query("select t from Tutorial t where ?1 member t.tags")
//    List<Post> findByTag(String tag);
}
