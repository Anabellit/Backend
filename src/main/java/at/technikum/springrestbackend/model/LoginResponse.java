package at.technikum.springrestbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {
    private String token;  // Der JWT-Token
    /*private Long userId;   // Die User-ID*/
}



/*import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {

    private final String token;
}*/
