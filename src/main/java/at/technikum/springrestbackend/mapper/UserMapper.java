package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setSalutation(user.getSalutation());
        userDto.setOther(user.getOther());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setCountry(user.getCountry());
        userDto.setPictureUrl(user.getPictureUrl());
        userDto.setToken(user.getToken());
        //userDto.setAdmin(user.isAdmin());
        userDto.setRole(user.getRole);

        return userDto;
    }

    public User toEntity(UserDto userDto) {
        if (userDto.getId() == null) {
            return new User(
                    UUID.randomUUID().toString(),
                    userDto.getSalutation(),
                    userDto.getOther(),
                    userDto.getEmail(),
                    userDto.getPassword(),
                    userDto.getCountry(),
                    userDto.getPictureUrl(),
                    userDto.getToken(),
                    /*userDto.isAdmin()*/
                    userDto.getRole()

            );
        }

        return new User(
                userDto.getId(),
                userDto.getSalutation(),
                userDto.getOther(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getCountry(),
                userDto.getPictureUrl(),
                userDto.getToken(),
                /*userDto.isAdmin()*/
                userDto.getRole()
        );
    }
}
