package at.technikum.springrestbackend.dto;

import at.technikum.springrestbackend.model.Amenity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.OneToOne;

import java.util.List;

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
    private UserDto userDto;

    private String pictureURL; // List

    private List<Amenity> amenities;

    public HouseDto() {
    }

    public HouseDto(String id, String address, String description, UserDto userDto) {
        this.id = id;
        this.address = address;
        this.description = description;
        this.userDto = userDto;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {

        this.userDto = userDto;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }


}
