package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.SongDto;
import ru.itis.springapp.repositories.SongRepository;

import java.util.List;

@Component
public class SongsServiceImpl implements SongsService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<SongDto> getSongsBySubstring(String substring) {
        return SongDto.from(songRepository.findAllBySubstring(substring));
    }

    @Override
    public List<SongDto> getAllSongs() {
        return SongDto.from(songRepository.findAll());
    }
}
