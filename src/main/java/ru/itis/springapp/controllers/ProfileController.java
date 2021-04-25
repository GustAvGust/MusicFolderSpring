package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springapp.dto.UserForm;
import ru.itis.springapp.models.FileInfo;
import ru.itis.springapp.models.User;
import ru.itis.springapp.security.details.UserDetailsImpl;
import ru.itis.springapp.services.FileStorageService;
import ru.itis.springapp.services.UsersService;

@Controller
public class ProfileController {

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile")
    public String show(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("user", userDetails.getUser());
        return "profile_page";
    }

    @PostMapping("/profile")
    public ResponseEntity<String> update(@RequestParam("avatar") MultipartFile avatar, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        FileInfo file = fileStorageService.saveFile(avatar);
        usersService.userUpdate(userDetails.getUser(), UserForm.builder().avatar(file).build());
        return ResponseEntity.ok(userDetails.getUser().getAvatar().getStorageFileName());
    }
}
