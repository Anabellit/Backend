package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.entity.UserEntity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {

    private final UserMapper userMapper = new UserMapper();

    @Test
    public void whenDtoNoId_thenUserEntityHasId() {
        UserDto userDto = new UserDto(null, "Mr.", null, "test@example.com", "password", "Austria", "url/to/picture", "token", "USER");
        UserEntity userEntity = userMapper.toEntity(userDto);

        assertNotNull(userEntity.getId(), "UserEntity ID should not be null after conversion");
    }

    @Test
    public void whenUserEntityValue_thenDtoSameValue() {
        UserEntity userEntity = new UserEntity("123e4567-e89b-12d3-a456-426614174000", "Mr.", "Other", "test@example.com", "password", "Austria", "url/to/picture", "token", "USER");
        UserDto userDto = userMapper.toDto(userEntity);

        assertEquals(userEntity.getId(), userDto.getId());
        assertEquals(userEntity.getSalutation(), userDto.getSalutation());
        assertEquals(userEntity.getEmail(), userDto.getEmail());
    }

    @Test
    public void whenDtoValue_thenUserEntitySameValue() {
        UserDto userDto = new UserDto("123e4567-e89b-12d3-a456-426614174000", "Mr.", "Other", "test@example.com", "password", "Austria", "url/to/picture", "token", "USER");
        UserEntity userEntity = userMapper.toEntity(userDto);

        assertEquals(userDto.getId(), userEntity.getId());
        assertEquals(userDto.getSalutation(), userEntity.getSalutation());
        assertEquals(userDto.getEmail(), userEntity.getEmail());
    }
}
