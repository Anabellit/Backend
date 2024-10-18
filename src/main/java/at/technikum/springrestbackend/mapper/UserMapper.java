package at.technikum.springrestbackend.mapper;

import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setSalutation(user.getSalutation());
        dto.setOtherSalutation(user.getOtherSalutation());
        dto.setEmail(user.getEmail());
        dto.setCountry(user.getCountry());
        dto.setRole(user.getRole());
        return dto;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setSalutation(userDto.getSalutation());
        user.setOtherSalutation(userDto.getOtherSalutation());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCountry(userDto.getCountry());
        user.setRole(userDto.getRole());
        return user;
    }
}



/*
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
                    */
/*userDto.isAdmin()*//*

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
                */
/*userDto.isAdmin()*//*

                userDto.getRole()
        );
    }
}
*/
