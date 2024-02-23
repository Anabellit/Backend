package at.technikum.springrestbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "amenities")
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;

    protected Amenity() {}
    public Amenity(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
