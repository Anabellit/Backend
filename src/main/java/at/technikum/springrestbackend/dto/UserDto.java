package at.technikum.springrestbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;           // UUID als String
    private String salutation;
    private String other;
    private String email;
    private String password;
    private String country;
    private String pictureUrl;
    private String token;
    private String role;
}
