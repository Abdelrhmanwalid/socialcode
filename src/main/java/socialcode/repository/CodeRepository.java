package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import socialcode.model.Code;
import socialcode.model.User;

import java.util.List;

@Repository("CodeRepository")
public interface CodeRepository extends JpaRepository<Code, Integer> {
    @Query("select count(c) from Code c where c.parent = ?1")
    int numberOfForks(Code code);

    @Query("select c from Code c where c.parent = ?1")
    List<Code> findForks(Code code);

    @Query("select c from Code c where c.user = ?1")
    List<Code> findByUser(User user);
}
