package ru.itis.springapp.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springapp.security.details.UserDetailsImpl;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("userFirstName", userDetails.getUser().getFirstName());
        model.addAttribute("userLastName", userDetails.getUser().getLastName());
        return "profile_page";
    }
}
