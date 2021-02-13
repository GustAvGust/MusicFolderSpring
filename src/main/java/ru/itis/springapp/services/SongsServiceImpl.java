package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springapp.models.Song;
import ru.itis.springapp.repositories.SongRepository;

import java.util.List;

@Component
public class SongsServiceImpl implements SongsService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getSongsByPrefix(String prefix) {
        return songRepository.findAllByPrefix(prefix);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}
