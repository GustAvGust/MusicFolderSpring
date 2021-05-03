package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springapp.dto.TeaDto;
import ru.itis.springapp.dto.TeaForm;
import ru.itis.springapp.models.User;
import ru.itis.springapp.security.details.UserDetailsImpl;
import ru.itis.springapp.services.StringParserService;
import ru.itis.springapp.services.TeasService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class TeaController {

    @Autowired
    private TeasService teasService;

    @Autowired
    private StringParserService stringParserService;

    private static final int DEFAULT_PAGE_AFTER_ADDING_TEA = 0;

    @GetMapping("/teas")
    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Integer page) {
        model.addAttribute("teas", teasService.getAllTeasByUser(userDetails.getUser(), page));
        model.addAttribute("page_number", teasService.getTeaPagesNumberByUser(userDetails.getUser()));
        return "teas_page";
    }

    @GetMapping("/teas/{tea-id}")
    public String show(Model model, @PathVariable("tea-id") Long teaId) {
        TeaDto teaDto = TeaDto.from(teasService.findTeaById(teaId));
        model.addAttribute("tea", teaDto);
        return "tea_page";
    }

    @PostMapping("/teas/{tea-id}")
    public String update(@PathVariable("tea-id") Long teaId, @RequestParam("teaName") String teaName,  @RequestParam("teaDescription") String teaDescription) {
        teasService.updateTea(teasService.findTeaById(teaId), TeaForm.builder().name(teaName).description(teaDescription).build());
        return "redirect:/teas?page=0";
    }

    @PostMapping("/teas")
    @ResponseBody
    public ResponseEntity<List<TeaDto>> create(@RequestBody String data, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            data = URLDecoder.decode(data, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String nameOfTea = stringParserService.getValueOfParamFromString(data, "name");
        String descriptionOfTea = stringParserService.getValueOfParamFromString(data, "description");
        User user = userDetails.getUser();

        TeaForm teaForm = TeaForm.builder()
                            .name(nameOfTea)
                            .description(descriptionOfTea)
                            .user(user)
                            .build();
        teasService.addNewTea(teaForm);
        return ResponseEntity.ok(teasService.getAllTeasByUser(user, DEFAULT_PAGE_AFTER_ADDING_TEA));
    }
}
