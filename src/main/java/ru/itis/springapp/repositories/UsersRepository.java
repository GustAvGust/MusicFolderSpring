package ru.itis.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
