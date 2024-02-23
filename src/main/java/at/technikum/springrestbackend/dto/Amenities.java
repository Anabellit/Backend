package at.technikum.springrestbackend.dto;

import java.util.List;

public class Amenities {
    private List<String> amenities;

    public Amenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}
