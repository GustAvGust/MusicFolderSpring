package ru.itis.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springapp.models.Playlist;
import ru.itis.springapp.models.Song;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlaylistDto {
    private Long id;
    private String name;
    private List<Song> songs;

    public static PlaylistDto from(Playlist playlist) {
        return PlaylistDto.builder()
                .id(playlist.getId())
                .name(playlist.getName())
                .songs(playlist.getSongs())
                .build();
    }

    public static List<PlaylistDto> from(List<Playlist> playlists) {
        return playlists.stream().map(PlaylistDto::from).collect(Collectors.toList());
    }
}
