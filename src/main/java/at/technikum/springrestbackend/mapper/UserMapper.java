package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Mapping von UserEntity zu UserDto
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(String.valueOf(userEntity.getId()));
        userDto.setSalutation(userEntity.getSalutation());
        userDto.setOther(userEntity.getOther());
        userDto.setEmail(userEntity.getEmail());
        userDto.setPassword(userEntity.getPassword());
        userDto.setCountry(userEntity.getCountry());
        userDto.setPictureUrl(userEntity.getPictureUrl());
        userDto.setToken(userEntity.getToken());
        userDto.setRole(userEntity.getRole());
        // Wenn du HouseDto mappen musst, füge es hier hinzu
        return userDto;
    }

    // Mapping von UserDto zu UserEntity
    public UserEntity toEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(Long.valueOf(userDto.getId())); // Falls ID nicht vorhanden ist, setze sie
        userEntity.setSalutation(userDto.getSalutation());
        userEntity.setOther(userDto.getOther());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword()); // Stelle sicher, dass das Passwort verschlüsselt wird
        userEntity.setCountry(userDto.getCountry());
        userEntity.setPictureUrl(userDto.getPictureUrl());
        userEntity.setToken(userDto.getToken());
        userEntity.setRole(userDto.getRole());
        // Wenn du HouseDto mappen musst, füge es hier hinzu
        return userEntity;
    }
}
