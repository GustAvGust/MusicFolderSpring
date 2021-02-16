package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springapp.models.State;
import ru.itis.springapp.models.User;
import ru.itis.springapp.repositories.UsersRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

@Component
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void confirmUserByCode(String code) {
        Optional<User> userOptional = usersRepository.findByConfirmCode(code);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setState(State.CONFIRMED);
            usersRepository.save(user);
        }
    }

    @Override
    public boolean isUserConfirmedByCode(String code) {
        Optional<User> userOptional = usersRepository.findByConfirmCode(code);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getState().equals(State.CONFIRMED);
        }
        return false;
    }
}
