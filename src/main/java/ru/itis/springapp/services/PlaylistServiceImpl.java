package ru.itis.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springapp.dto.PlaylistDto;
import ru.itis.springapp.dto.PlaylistForm;
import ru.itis.springapp.models.Playlist;
import ru.itis.springapp.models.Song;
import ru.itis.springapp.models.User;
import ru.itis.springapp.repositories.PlaylistRepository;
import ru.itis.springapp.repositories.SongRepository;
import ru.itis.springapp.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Component
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SongRepository songRepository;

    @Override
    public PlaylistDto addPlaylistToUser(Long userId, PlaylistForm playlistForm) {
        Optional<User> user = usersRepository.findById(userId);
        if (user.isPresent()) {
            Playlist newPlaylist = Playlist.builder()
                    .user(user.get())
                    .name(playlistForm.getName())
                    .build();

            playlistRepository.save(newPlaylist);
            return PlaylistDto.from(newPlaylist);
        }

        return null;
    }

    @Override
    public List<PlaylistDto> getAllByUser(Long userId) {
        return PlaylistDto.from(playlistRepository.findAllByUserId(userId));
    }

    @Override
    public PlaylistDto addSongToPlaylist(Long userId, Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findByUserIdAndId(userId, playlistId);
        Song song = songRepository.getOne(songId);
        if (playlist.getSongs().contains(song)) {
            playlist.getSongs().remove(song);
        } else {
            playlist.getSongs().add(song);
        }

        playlistRepository.save(playlist);
        return PlaylistDto.from(playlist);
    }
}

