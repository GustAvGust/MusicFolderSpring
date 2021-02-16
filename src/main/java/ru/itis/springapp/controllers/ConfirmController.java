package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springapp.services.ConfirmService;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmService confirmService;

    @GetMapping("/confirmed_successfully")
    public String getSuccessPage() {
        return "confirmed_successfully";
    }

    @GetMapping("/confirmed_wrong")
    public String getWrongPage() {
        return "confirmed_wrong";
    }

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code) {
        // TODO: реализовать сервис для подтерждения (найти по коду человека и поставить ему статус CONFIRMED)
        confirmService.confirmUserByCode(code);
        // TODO: вернуть страницу об успешном прохождении подтверждения
        if (confirmService.isUserConfirmedByCode(code)) {
            return "redirect:/confirmed_successfully";
        } else {
            return "redirect:/confirmed_wrong";
        }
    }
}

