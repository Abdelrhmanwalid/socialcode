package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.User;

import java.util.List;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email = ?1")
	User findByUserEmail(String email);

	@Query("select u from User u where u.first_name = ?1 or u.last_name = ?1")
	List<User> findByUserName(String name);

	@Query("select u from User u where ?1 member of u.followers")
	List<User> findFollowing(User user);

}
