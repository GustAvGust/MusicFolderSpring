package ru.itis.springapp.services;

import ru.itis.springapp.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    UserDto getUser(Long userId);
}
