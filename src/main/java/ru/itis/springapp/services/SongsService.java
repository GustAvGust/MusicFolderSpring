package ru.itis.springapp.services;

import ru.itis.springapp.models.Song;

import java.util.List;

public interface SongsService {
    List<Song> getSongsByPrefix(String prefix);
    List<Song> getAllSongs();
}
