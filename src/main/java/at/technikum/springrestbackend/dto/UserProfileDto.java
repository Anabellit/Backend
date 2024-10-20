package at.technikum.springrestbackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfileDto {

    @NotBlank(message = "Country is required.")
    private String country;

    @NotBlank(message = "Username is required.")
    private String username;

    @NotBlank(message = "Email is required.")
    private String email;
}
