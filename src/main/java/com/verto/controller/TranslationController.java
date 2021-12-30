package com.verto.controller;

import com.verto.model.TranslationModel;
import com.verto.service.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("")
    public String list() {
        return "list";
    }

    @PostMapping("/create")
    public TranslationModel create(@RequestBody TranslationModel t) {
        String guid = UUID.randomUUID().toString();
        t.setGuid(guid);
        t.setIsGroup(false);
        // this.translationService.insertIntoDatabase(t);
        return new TranslationModel(t.getGuid(), t.getKey(), t.getValue(), t.getIsGroup(), t.getLanguageGuid());
    }

    @GetMapping("/get")
    public String get() {
        return "get";
    }

}
