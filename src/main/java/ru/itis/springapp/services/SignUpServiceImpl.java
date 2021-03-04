package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.UserForm;
import ru.itis.springapp.models.State;
import ru.itis.springapp.models.User;
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

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .email(form.getEmail())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .avatarUrl("default")
                .state(State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .password(passwordEncoder.encode(form.getPassword()))
                .build();

        usersRepository.save(newUser);

        mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
    }
}
