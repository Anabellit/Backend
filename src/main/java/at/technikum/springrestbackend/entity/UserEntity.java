package at.technikum.springrestbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

    private Long id;
    private String email;

    @JsonIgnore
    private String password;

    private String role;

    private String country;

    private String salutation;

    private String other;

    private String pictureUrl;

    private String token;

    // Getter und Setter werden von Lombok erzeugt
}
