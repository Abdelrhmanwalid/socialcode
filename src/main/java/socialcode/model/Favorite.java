package socialcode.model;

import javax.persistence.*;

@Entity
@Table(name = "Favorites")
public class Favorite {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
