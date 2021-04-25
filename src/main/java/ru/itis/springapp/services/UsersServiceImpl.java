package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.UserDto;
import ru.itis.springapp.dto.UserForm;
import ru.itis.springapp.models.User;
import ru.itis.springapp.repositories.UsersRepository;

import java.util.List;
import static ru.itis.springapp.dto.UserDto.*;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(usersRepository.findById(userId).orElse(User.builder().build()));
    }

    @Override
    public void userUpdate(User currentUser, UserForm userParams) {
        if (userParams.getFirstName() != null) {
            currentUser.setFirstName(userParams.getFirstName());
        }
        if (userParams.getLastName() != null) {
            currentUser.setLastName(userParams.getLastName());
        }
        if (userParams.getAvatar() != null) {
            currentUser.setAvatar(userParams.getAvatar());
        }
        usersRepository.save(currentUser);
    }
}
