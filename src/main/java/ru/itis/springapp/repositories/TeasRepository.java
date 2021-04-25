package ru.itis.springapp.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.Tea;
import ru.itis.springapp.models.User;

import java.util.List;

public interface TeasRepository extends JpaRepository<Tea, Long> {
    List<Tea> findAllByUser(User user, Pageable pageable);
    Long countAllByUser(User user);
}
