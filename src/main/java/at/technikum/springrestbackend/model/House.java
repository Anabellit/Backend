package at.technikum.springrestbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String address;

    private String description;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



