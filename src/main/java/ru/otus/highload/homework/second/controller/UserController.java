package ru.otus.highload.homework.second.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;
import ru.otus.highload.homework.second.dto.RegisterDto;
import ru.otus.highload.homework.second.dto.UserDto;
import ru.otus.highload.homework.second.dto.UserSearchDto;
import ru.otus.highload.homework.second.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping("/user/get/{id}")
    @Operation(summary = "Получение анкеты пользователя")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user/register")
    @Operation(summary = "Регистрация нового пользователя")
    public Long registerUser(@RequestBody RegisterDto registerDto) {
        return userService.registerUser(registerDto);
    }


    @PostMapping("/login")
    @Operation(summary = "Вход в систему")
    public void login() {
    }

    @GetMapping("/user/search")
    @Operation(summary = "Поиск анкеты пользователя")
    public List<UserDto> userSearch(@ParameterObject UserSearchDto dto) {
        return userService.getUserByNameAndSurname(dto.firstName(), dto.lastName());
    }
}
