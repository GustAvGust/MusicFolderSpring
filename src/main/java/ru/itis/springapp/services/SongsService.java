package ru.itis.springapp.services;

import ru.itis.springapp.dto.SongDto;

import java.util.List;

public interface SongsService {
    List<SongDto> getSongsBySubstring(String substring);
    List<SongDto> getAllSongs();
}
