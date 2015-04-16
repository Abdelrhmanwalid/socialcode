package socialcode.model;

import javax.persistence.*;

@Entity
@Table(name = "Images")
public class Image {

    @GeneratedValue
    @Id
    private int id;
    @Column(name = "image_location")
    private String imageLocation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}
