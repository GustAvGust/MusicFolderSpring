package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springapp.dto.SongDto;
import ru.itis.springapp.services.PlaylistService;
import ru.itis.springapp.services.StringParserService;
import ru.itis.springapp.services.SongsService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private SongsService songsService;

    @Autowired
    private StringParserService stringParserService;

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/main_page")
    public String getMainPage() {
        return "main_page";
    }

    @PostMapping("/main_page")
    @ResponseBody
    public ResponseEntity<List<SongDto>> search(@RequestBody String data) {
        String substring = stringParserService.getValueOfParamFromString(data, "substring");

        if (substring != null) {
            return ResponseEntity.ok(songsService.getSongsBySubstring(substring));
        } else {
            return ResponseEntity.ok(songsService.getAllSongs());
        }
    }

    @PostMapping("/main_page/users/{user-id}/playlists/{playlist-id}/songs/{song-id}")
    @ResponseBody
    public ResponseEntity<List<SongDto>> addSongToPlaylist(@PathVariable("user-id") Long userId,
                                                        @PathVariable("playlist-id") Long playlistId,
                                                        @PathVariable("song-id") Long songId) {
        return ResponseEntity.ok(SongDto.from(playlistService.addSongToPlaylist(userId, playlistId, songId).getSongs()));
    }
}
