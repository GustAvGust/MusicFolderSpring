package ru.itis.springapp.services;


import ru.itis.springapp.dto.PlaylistDto;
import ru.itis.springapp.dto.PlaylistForm;

import java.util.List;

public interface PlaylistService {
    PlaylistDto addPlaylistToUser(Long userId, PlaylistForm playlistForm);

    List<PlaylistDto> getAllByUser(Long userId);

    PlaylistDto addSongToPlaylist(Long userId, Long playlistId, Long songId);
}
