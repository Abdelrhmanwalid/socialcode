package socialcode.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "Tutorials")
public class Tutorial {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    @Type(type = "text")
    private String text;
    @OneToOne
    @JoinColumn(nullable = false)
    private Post post;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
