package at.technikum.springrestbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.OneToOne;

// Boolean hidden
public class HouseDto {

    @NotBlank
    private String id;

    @NotBlank
    private String caption;

    @NotBlank
    private String description;

    @NotBlank
    private String address;

    @NotBlank
    @OneToOne
    private String user;

    private String pictureURL; // List

    private Amenities amenities;

    public HouseDto() {
    }

    public HouseDto(String id, String address, String description) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {

        this.user = user;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Amenities getAmenities() {
        return amenities;
    }

    public void setAmenities(Amenities amenities) {
        this.amenities = amenities;
    }
}
