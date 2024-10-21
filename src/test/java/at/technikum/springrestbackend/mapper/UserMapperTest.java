package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {

    private final UserMapper userMapper = new UserMapper();

    @Test
    void whenUserValue_thenDtoSameValue() {
        // Arrange
        Long id = 1L;
        User user = new User(id,
                "Frau",
                "Other",
                "test@testnetzwerk.at",
                "passwort567",
                "Germany",
                "1234",
                "ADMIN");

        // Act
        UserDto userDto = userMapper.toDto(user);

        // Assert
        assertEquals(id, userDto.getId());
        assertEquals("test@testnetzwerk.at", userDto.getEmail());
        assertEquals("Germany", userDto.getCountry());
        assertEquals("ADMIN", userDto.getRole());
    }

    @Test
    void whenDtoNoId_thenUserHasId() {
        // Arrange
        UserDto userDto = new UserDto();
        userDto.setEmail("test@testnetzwerk.at");

        // Act
        User user = userMapper.toEntity(userDto);

        // Assert
        assertNotNull(user.getId());
        assertEquals("test@testnetzwerk.at", user.getEmail());
    }

    @Test
    void whenDtoValue_thenUserSameValue() {
        // Arrange
        Long id = 1L;
        UserDto userDto = new UserDto(id,
                "Frau",
                "Other",
                "test@testnetzwerk.at",
                "passwort567",
                "Germany",
                "1234",
                "USER");

        // Act
        User user = userMapper.toEntity(userDto);

        // Assert
        assertEquals(id, user.getId());
        assertEquals("test@testnetzwerk.at", user.getEmail());
        assertEquals("USER", user.getRole());
        assertEquals("Germany", user.getCountry());
    }
}
