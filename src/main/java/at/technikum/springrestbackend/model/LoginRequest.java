package at.technikum.springrestbackend.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
