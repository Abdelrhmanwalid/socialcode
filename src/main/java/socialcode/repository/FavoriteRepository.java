package socialcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialcode.model.Favorite;

@Repository("favoriteRepository")
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
