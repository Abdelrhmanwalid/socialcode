package socialcode.model;

import javax.persistence.*;

@Entity
@Table(name = "Tags")
public class Tag {

    @Id
    @GeneratedValue
    protected int id;
    @Column(nullable = false)
    protected String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
