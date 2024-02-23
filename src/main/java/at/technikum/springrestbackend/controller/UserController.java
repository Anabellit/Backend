package at.technikum.springrestbackend.controller;


import at.technikum.springrestbackend.dto.UserDto;
import at.technikum.springrestbackend.mapper.UserMapper;
import at.technikum.springrestbackend.model.User;
import at.technikum.springrestbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


//Controller
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(
                UserMapper userMapper,
                UserService userService
    ) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> readAll() {
        return userService.findAll().stream()
            .map(userMapper::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto read(@PathVariable String id) {
        User user = userService.find(id);
        return userMapper.toDto(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user = userService.save(user);
        return userMapper.toDto(user);
    }


    // anpassen für update:
    // finden des users nach id und etwas ändern
    // returned dann das, was geändert wurde
    @PutMapping("/{id}")
    public UserDto update(@PathVariable String id) {
        return new UserDto("1", "female", "", "testerin@test.at", "passwd123",
                "Australia", "pic123", "1234ertt", true);
    }

    @DeleteMapping("/{id}")
    public UserDto delete(@PathVariable String id) {
        return new UserDto("1", "male", "", "tester@test.at", "passwd123",
                "Norway", "pic456", "oiweoriwer43", false);
    }
}




