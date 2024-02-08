package at.technikum.springrestbackend.dto;

public class UserDto {

    //FELDER
    private String id;

    // wie macht man für Select, die einzigen Werte, die möglich sind?
    // --> muss geprüft werden im Backend (m, w, d)
    private String salutation;

    // other ist verpflichtend, wenn bei Salutation bestimmter Wert "d" ausgewählt wird.
    // wie wird das im Constructor dargestellt?
    private String other;

    private String email;

    private String password;

    private String country;

    private String pictureUrl; // wenn keines hochgeladen wird, dann nimm das default picture

    private String token;

    private boolean isAdmin;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "houseid", referencedColumnName = "id")
    private House house;*/



    // CONSTRUCTOR
    public UserDto (){
    }

    //constructor für, wenn "d" in salutation ausgewählt wurde
    public UserDto(String id,
                   String salutation,
                   String other,
                   String email,
                   String password,
                   String country,
                   String pictureUrl,
                   String token,
                   boolean isAdmin) {
        this.id = id;
        this.salutation = salutation;
        this.other = other;
        this.email = email;
        this.password = password;
        this.country = country;
        this.pictureUrl = pictureUrl;
        this.token = token;
        this.isAdmin = isAdmin;
    }

    // constructor für, wenn "m" oder "f" bei salutation ausgewählt wurde
    public UserDto(String id,
                   String salutation,
                   String email,
                   String password,
                   String country,
                   String pictureUrl,
                   String token,
                   boolean isAdmin) {
        this.id = id;
        this.salutation = salutation;
        this.email = email;
        this.password = password;
        this.country = country;
        this.pictureUrl = pictureUrl;
        this.token = token;
        this.isAdmin = isAdmin;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
