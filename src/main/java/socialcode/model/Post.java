package socialcode.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "varchar(10)")
    private String type;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToMany
    List<User> favoritedBy;

    public List<User> getFavoritedBy() {
        return favoritedBy;
    }

    public void setFavoritedBy(List<User> favoritedBy) {
        this.favoritedBy = favoritedBy;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}