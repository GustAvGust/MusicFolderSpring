package ru.itis.springapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springapp.models.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("select s from Song s where lower(s.name) like concat('%', lower(?1), '%')")
    List<Song> findAllBySubstring(String substring);
}
