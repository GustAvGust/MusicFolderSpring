package ru.itis.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByConfirmCode(String confirmCode);
    Optional<User> findByEmail(String email);
}
