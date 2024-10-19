package at.technikum.springrestbackend.controller;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:63343")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // POST - Registrierung eines neuen Benutzers
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto userDto) {
        Map<String, String> errorResponse = new HashMap<>();

        // Überprüfung, ob die E-Mail bereits existiert
        if (userService.emailExists(userDto.getEmail())) {
            errorResponse.put("error", "Email already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse); // 409 Conflict
        }

        // Überprüfung, ob der Benutzername bereits existiert
        if (userService.usernameExists(userDto.getUsername())) {
            errorResponse.put("error", "Username already exists.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse); // 409 Conflict
        }

        // Wenn E-Mail und Benutzername beide verfügbar sind
        UserDto createdUser = userService.registerUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser); // 201 Created
    }

    // GET - Abrufen eines Benutzers anhand der ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserDto userDto = userService.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(userDto); // 200 OK
        } catch (RuntimeException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "User with ID " + id + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse); // 404 Not Found
        }
    }

    // PUT - Aktualisieren eines Benutzers anhand der ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,
                                        @RequestBody
                                        @Valid UserDto userDto) {
        try {
            // Überprüfung, ob der Benutzername bereits existiert (außer der aktuelle Benutzer)
            if (userService.usernameExists(userDto.getUsername())
                    && !userService.getUserById(id).getUsername().equals(userDto.getUsername())) {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Username already exists.");
                // 409 Conflict
                return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
            }

            UserDto updatedUser = userService.updateUser(id, userDto);
            return ResponseEntity.status(HttpStatus.OK).body(updatedUser); // 200 OK
        } catch (RuntimeException ex) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "User with ID " + id + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse); // 404 Not Found
        }
    }
}
