package socialcode.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Tags")
public class Tag {

    @EmbeddedId
    private TagIds id;

    public TagIds getId() {
        return id;
    }

    public void setId(TagIds id) {
        this.id = id;
    }

    @Embeddable
    public class TagIds implements Serializable {

        @GeneratedValue
        protected int id;
        protected String tag;

        public TagIds() {
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }
}
