package ru.itis.springapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springapp.models.Song;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SongDto {
    private Long id;
    private String name;

    public static SongDto from(Song song) {
        return SongDto.builder()
                .id(song.getId())
                .name(song.getName())
                .build();
    }

    public static List<SongDto> from(List<Song> songs) {
        return songs.stream()
                .map(SongDto::from)
                .collect(Collectors.toList());
    }
}
