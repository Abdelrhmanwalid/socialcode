package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.Follower;

@Repository("FollowerRepository ")
public interface FollowerRepository extends JpaRepository<Follower, Integer> {
}
