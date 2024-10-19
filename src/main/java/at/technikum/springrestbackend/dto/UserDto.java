package at.technikum.springrestbackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank(message = "Salutation is required.")
    private String salutation;

    private String otherSalutation;

    @NotBlank(message = "Username is required.")
    private String username;

    @Email(message = "Invalid email address.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{12,}",
            message = "Password must contain at least 12 characters, " +
                    "with uppercase, lowercase, numbers, and symbols.")
    private String password;

    @NotBlank(message = "Country is required.")
    private String country;

    @NotBlank(message = "Role is required.")
    private String role;  // Füge das Role-Feld hinzu

}



/*
package at.technikum.springrestbackend.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UserDto {


    private String id;

    // FE Frage: wie macht man für Select, die einzigen Werte, die möglich sind?
    // --> muss geprüft werden im Backend (m, w, d)
    @NotBlank
    private String salutation;

    // other ist verpflichtend, wenn bei Salutation bestimmter Wert "d" ausgewählt wird.
    private String other;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    @NotBlank
    private String country;

    private String pictureUrl; // wenn keines hochgeladen wird, dann nimm das default picture

    @NotBlank
    private String token;

    */
/*private boolean isAdmin;*//*

    private String role;

    private HouseDto houseDto;




    public UserDto (){
    }

    public UserDto(String id,
                   String salutation,
                   String other,
                   String email,
                   String password,
                   String country,
                   String pictureUrl,
                   String token,
                   String role
                   */
/*boolean isAdmin*//*
) {
        this.id = id;
        this.salutation = salutation;
        this.other = other;
        this.email = email;
        this.password = password;
        this.country = country;
        this.pictureUrl = pictureUrl;
        this.token = token;
        */
/*this.isAdmin = isAdmin;*//*

        this.role = role;

    }




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

    */
/*public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }*//*


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public HouseDto getHouseDto() {
        return houseDto;
    }

    public void setHouseDto(HouseDto houseDto) {
        this.houseDto = houseDto;
    }
}
*/
