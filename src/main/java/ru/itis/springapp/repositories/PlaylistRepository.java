package ru.itis.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springapp.models.Playlist;
import ru.itis.springapp.models.Song;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findAllByUserId(Long userId);

    Playlist findByUserIdAndId(Long userId, Long playlistId);
//    Optional<Playlist> findByNamePlaylistAndUserId(String name, Long userId);
}
