package at.technikum.springrestbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String salutation;

    private String other;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String country;

    @NotBlank
    private String pictureUrl;

    @NotBlank
    private String token;

    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "houseid", referencedColumnName = "id")
    private House house;

    // No-args constructor for JPA
    public User() {
    }

    public User(String id, String salutation, String other, String email, String password,
                String country, String pictureUrl, String token, String role, House house) {
        this.id = id;
        this.salutation = salutation;
        this.other = other;
        this.email = email;
        this.password = password;
        this.country = country;
        this.pictureUrl = pictureUrl != null ? pictureUrl : "resources/user_default_photo.jpg";
        this.token = token;
        this.role = role;
        this.house = house;
    }

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl != null ? pictureUrl : "resources/user_default_photo.jpg";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
