package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Follower;
import socialcode.repository.FollowerRepository;

@Service("FollowerService")
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    public Follower save(Follower follower) {
        followerRepository.save(follower);
        return follower;
    }
}
