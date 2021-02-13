package ru.itis.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//    List<Playlist> findAllByUserId(Long userId);
//
//    Optional<Playlist> findByNamePlaylistAndUserId(String name, Long userId);
}
