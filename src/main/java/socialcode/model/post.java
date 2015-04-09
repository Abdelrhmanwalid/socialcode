package socialcode.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue
    private int id;
    @Column(columnDefinition = "varchar(10)")
    private String type;
    @Column(nullable = false)
    private int user_id;
    @OneToMany
    @JoinTable(name = "Favorites")
    List<User> Favorites = new ArrayList<User>();

    public List<User> getFavorites() {
        return Favorites;
    }

    public void setFavorites(List<User> favorites) {
        Favorites = favorites;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
