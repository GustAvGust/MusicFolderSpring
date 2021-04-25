package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.UserForm;
import ru.itis.springapp.models.FileInfo;
import ru.itis.springapp.models.Role;
import ru.itis.springapp.models.State;
import ru.itis.springapp.models.User;
import ru.itis.springapp.repositories.FileInfoRepository;
import ru.itis.springapp.repositories.UsersRepository;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailsService mailsService;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .email(form.getEmail())
                .firstName(firstUpperCase(form.getFirstName()))
                .lastName(firstUpperCase(form.getLastName()))
                .avatar(fileInfoRepository.findById(Long.valueOf(1)).get())
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .confirmCode(UUID.randomUUID().toString())
                .password(passwordEncoder.encode(form.getPassword()))
                .build();

        usersRepository.save(newUser);

        mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
    }

    private String firstUpperCase(String firstName) {
        if (firstName == null) {
            return "";
        }
        return firstName.substring(0, 1).toUpperCase() +
                firstName.substring(1).toLowerCase();
    }
}
