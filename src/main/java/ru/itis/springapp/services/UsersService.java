package ru.itis.springapp.services;

import ru.itis.springapp.dto.UserDto;
import ru.itis.springapp.dto.UserForm;
import ru.itis.springapp.models.User;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    UserDto getUser(Long userId);
    void userUpdate(User currentUser, UserForm userParams);
}
