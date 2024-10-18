/*
package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.model.User;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserMapperTest {
    @Test
    void whenUserValue_thenDtoSameValue() {
        // Arrange
        UserMapper userMapper = new UserMapper();
        String id = UUID.randomUUID().toString();
        User user = new User(id,
                "Frau",
                "",
                "test@testnetzwerk.at",
                "passwort567",
                "Germany",
                "1234",
                "werwr",
                "ADMIN");

        // Act
        UserDto userDto = userMapper.toDto(user);

        // Assert
        assertEquals(id, userDto.getId());
        assertEquals("test@testnetzwerk.at", userDto.getEmail());
    }

    @Test
    void whenDtoNoId_thenUserHasId() {
        // Arrange
        UserMapper userMapper = new UserMapper();
        UserDto userDto = new UserDto();
        userDto.setEmail("test@testnetzwerk.at");

        // Act
        User user = userMapper.toEntity(userDto);

        // Assert
        assertNotNull(user.getId());
    }

    @Test
    void whenDtoValue_thenUserSameValue() {
        // Arrange
        UserMapper userMapper = new UserMapper();
        String id = UUID.randomUUID().toString();
        UserDto userDto = new UserDto(id,
                "Frau",
                "",
                "test@testnetzwerk.at",
                "passwort567",
                "Germany",
                "1234",
                "werwr",
                "USER");

        // Act
        User user = userMapper.toEntity(userDto);

        // Assert
        assertEquals(id, user.getId());
        assertEquals("test@testnetzwerk.at", user.getEmail());
    }
}
*/
