package socialcode.model;

import javax.persistence.*;

@Entity
@Table(name = "tutorial_tags")
public class TutorialTags {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(nullable = false)
    protected Tag tag;
    @ManyToOne
    @JoinColumn(nullable = false)
    protected Tutorial tutorial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }
}
