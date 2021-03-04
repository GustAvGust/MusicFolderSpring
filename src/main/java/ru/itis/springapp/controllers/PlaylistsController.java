package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springapp.dto.PlaylistDto;
import ru.itis.springapp.dto.PlaylistForm;
import ru.itis.springapp.services.PlaylistService;

@Controller
public class PlaylistsController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/users/{user-id}/playlists")
    @ResponseBody
    public PlaylistDto addPlaylist(@PathVariable("user-id") Long userId, @RequestBody PlaylistForm playlistForm) {
        return playlistService.addPlaylistToUser(userId, playlistForm);
    }

    @GetMapping("/users/{user-id}/playlists")
    public String showAllPlaylistsOfUser(@PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("playlists", playlistService.getAllByUser(userId));
        return "playlists_page";
    }
}
