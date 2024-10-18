package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        // Setzen der ID, wenn sie nicht vorhanden ist
        if (userDto.getId() == null) {
            userEntity.setId(UUID.randomUUID().toString()); // Generiere eine neue UUID
        } else {
            userEntity.setId(userDto.getId());
        }

        userEntity.setSalutation(userDto.getSalutation());
        userEntity.setOther(userDto.getOther());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setCountry(userDto.getCountry());
        userEntity.setPictureUrl(userDto.getPictureUrl());
        userEntity.setToken(userDto.getToken());
        userEntity.setRole(userDto.getRole());

        return userEntity;
    }

    public UserDto toDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getSalutation(),
                userEntity.getOther(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getCountry(),
                userEntity.getPictureUrl(),
                userEntity.getToken(),
                userEntity.getRole()
        );
    }
}
