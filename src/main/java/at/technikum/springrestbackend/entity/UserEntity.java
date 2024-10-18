package at.technikum.springrestbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class UserEntity {

    // ID als String (für UUID)
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; // UUID als String

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

    // Standard-Konstruktor
    public UserEntity() {}

    // Konstruktor mit Parametern
    public UserEntity(String id, String salutation, String other, String email,
                      String password, String country, String pictureUrl,
                      String token, String role) {
        this.id = id;
        this.salutation = salutation;
        this.other = other;
        this.email = email;
        this.password = password;
        this.country = country;
        this.pictureUrl = pictureUrl;
        this.token = token;
        this.role = role;
    }

    // Getter und Setter
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
        this.pictureUrl = pictureUrl;
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
}
