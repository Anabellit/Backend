package at.technikum.springrestbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder // Optional, falls du den Builder verwenden möchtest
public class LoginResponse {
    private String token;
    private String email;
    private String role;
}
