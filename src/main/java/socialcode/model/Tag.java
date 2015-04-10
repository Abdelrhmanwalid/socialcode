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
}
