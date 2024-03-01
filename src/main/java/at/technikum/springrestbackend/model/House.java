package at.technikum.springrestbackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String caption;

    private String description;

    private String address;

    private String pictureURL;

   // @Embedded
    @OneToMany
    @JoinColumn(name = "houses_id")
    private List<Amenity> amenities;

    @OneToOne
    private User user;

    protected House() {}

    public House(String id, String address, String description, User user) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.user = user;
    }

    public House(String id, String address, String description) {
        this.id = id;
        this.address = address;
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
}



