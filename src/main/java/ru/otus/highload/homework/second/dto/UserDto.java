package ru.otus.highload.homework.second.dto;

import ru.otus.highload.homework.second.enums.Gender;

import java.util.Calendar;

public record UserDto(Long id,String name, String surname, Calendar birthday, Gender gender, String interests, String city) {
}
