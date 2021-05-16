package ru.itis.springapp.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.Collection;
import ru.itis.springapp.models.User;

import java.util.List;

public interface CollectionsRepository extends JpaRepository<Collection, Long> {
    List<Collection> findAllByUser(User user, Pageable pageable);

    Long countAllByUser(User user);
}
