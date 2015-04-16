package socialcode.model;


import javax.persistence.*;

@Entity
@Table(name = "Followers")
public class Follower {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User follower;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
