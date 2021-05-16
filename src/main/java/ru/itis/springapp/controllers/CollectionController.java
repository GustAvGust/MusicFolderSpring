package ru.itis.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springapp.dto.CollectionDto;
import ru.itis.springapp.dto.CollectionForm;
import ru.itis.springapp.models.User;
import ru.itis.springapp.security.details.UserDetailsImpl;
import ru.itis.springapp.services.StringParserService;
import ru.itis.springapp.services.CollectionsService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class CollectionController {
    @Autowired
    private CollectionsService collectionsService;

    @Autowired
    private StringParserService stringParserService;

    private static final int DEFAULT_PAGE_AFTER_ADDING_COLLECTION = 0;

    @GetMapping("/collections")
    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestParam Integer page) {
        model.addAttribute("collections", collectionsService.getAllCollectionsByUser(userDetails.getUser(), page));
        model.addAttribute("page_number", collectionsService.getCollectionPagesNumberByUser(userDetails.getUser()));
        return "collections_page";
    }

    @GetMapping("/collections/{collection-id}")
    public String show(Model model, @PathVariable("collection-id") Long collectionId) {
        CollectionDto collectionDto = CollectionDto.from(collectionsService.findCollectionById(collectionId));
        model.addAttribute("collection", collectionDto);
        return "collection_page";
    }

    @PostMapping("/collections/{collection-id}")
    public String update(@PathVariable("collection-id") Long collectionId, @RequestParam("collectionName") String collectionName,  @RequestParam("collectionDescription") String collectionDescription) {
        collectionsService.updateCollection(collectionsService.findCollectionById(collectionId), CollectionForm.builder().name(collectionName).description(collectionDescription).build());
        return "redirect:/collections?page=0";
    }

    @PostMapping("/collections")
    @ResponseBody
    public ResponseEntity<List<CollectionDto>> create(@RequestBody String data, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            data = URLDecoder.decode(data, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String nameOfCollection = stringParserService.getValueOfParamFromString(data, "name");
        String descriptionOfCollection = stringParserService.getValueOfParamFromString(data, "description");
        User user = userDetails.getUser();

        CollectionForm collectionForm = CollectionForm.builder()
                .name(nameOfCollection)
                .description(descriptionOfCollection)
                .user(user)
                .build();
        collectionsService.addNewCollection(collectionForm);
        return ResponseEntity.ok(collectionsService.getAllCollectionsByUser(user, DEFAULT_PAGE_AFTER_ADDING_COLLECTION));
    }
}
