package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.Code;

@Repository("codeRepository")
public interface CodeRepository extends JpaRepository<Code, Integer> {
}
