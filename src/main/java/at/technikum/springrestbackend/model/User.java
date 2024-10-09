package at.technikum.springrestbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    public String getRole;
    //FELDER
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // wie macht man für Select, die einzigen Werte, die möglich sind?
    // --> muss geprüft werden im Backend (m, w, d)
    @NotBlank
    private String salutation;

    // other ist verpflichtend, wenn bei Salutation bestimmter Wert "d" ausgewählt wird.
    private String other;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String country;

    @NotBlank
    private String pictureUrl; // wenn keines hochgeladen wird, dann nimm das default picture

    @NotBlank
    private String token;

    /*private boolean isAdmin;*/

    private String role;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "houseid", referencedColumnName = "id")
    private House house;

    // CONSTRUCTOR

    protected User() {}

    public User(String id,
                String salutation,
                String other,
                String email,
                String password,
                String country,
                String pictureUrl,
                String token,
                /*boolean isAdmin,*/
                String role,
                House house) {
        this.id = id;
        this.salutation = salutation;
        this.other = other;
        this.email = email;
        this.password = password;
        this.country = country;
        if (pictureUrl == null){
            this.pictureUrl = "resources/user_default_photo.jpg";
        } else {
            this.pictureUrl = pictureUrl;
        }
        this.token = token;
        /*this.isAdmin = isAdmin;*/
        this.role = role;
        this.house = house;
    }

    //Construktor ohne House
    public User(String id,
                String salutation,
                String other,
                String email,
                String password,
                String country,
                String pictureUrl,
                String token,
                String role
                /*boolean isAdmin*/) {
        this.id = id;
        this.salutation = salutation;
        this.other = other;
        this.email = email;
        this.password = password;
        this.country = country;
        if (pictureUrl == null){
            this.pictureUrl = "resources/user_default_photo.jpg";
        } else {
            this.pictureUrl = pictureUrl;
        }
        this.token = token;
        /*this.isAdmin = isAdmin;*/
        this.role = role;
    }

    // GETTER UND SETTER
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

   /* public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }*/

    public String getGetRole() {
        return getRole;
    }

    public void setGetRole(String getRole) {
        this.getRole = getRole;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        if (pictureUrl == null){
            this.pictureUrl = "resources/user_default_photo.jpg";
        } else {
            this.pictureUrl = pictureUrl;
        }
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
