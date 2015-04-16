package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.Image;

@Repository("ImageRepository")
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
