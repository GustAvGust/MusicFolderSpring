package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springapp.models.Song;
import ru.itis.springapp.services.StringParserService;
import ru.itis.springapp.services.SongsService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private SongsService songsService;

    @Autowired
    private StringParserService stringParserService;

    @GetMapping("/main_page")
    public String getMainPage() {
        return "main_page";
    }

    @PostMapping("/main_page")
    @ResponseBody
    public ResponseEntity<List<Song>> search(@RequestBody String data) {
        System.out.println(data);
        String prefix = stringParserService.getValueOfParamFromString(data, "substring");

        if (prefix != null) {
            return ResponseEntity.ok(songsService.getSongsByPrefix(prefix));
        } else {
            return ResponseEntity.ok(songsService.getAllSongs());
        }
    }

}
