package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Favorite;
import socialcode.repository.FavoriteRepository;

@Service("FavoriteService")
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite save(Favorite favorite) {
        favoriteRepository.save(favorite);
        return favorite;
    }
}
