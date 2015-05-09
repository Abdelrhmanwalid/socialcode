package socialcode.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, length = 45)
    private int id;
    @Length(min = 1, message = "First name is required")
    private String first_name;
    @Length(min = 1, message = "Last name is required")
    private String last_name;
    @Length.List({
            @Length(min = 6, message = "6 chars at least"),
            @Length(max = 30, message = "Too long password to remember")
    })
    private String password;
    @Column(unique = true)
    @Email(message = "Email not valid")
    @NotEmpty
    private String email;
    @OneToOne
    @JoinColumn(name = "profile_picture")
    private Image profilePicture;
    @Type(type = "text")
    String biography;
    @ManyToMany
    List<User> followers = new ArrayList<User>();

    public User() {

    }

    public User(int id, String first_name, String last_name, String password,
                String email) {
        super();
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public Image getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Image profilePicture) {
        this.profilePicture = profilePicture;
    }


}