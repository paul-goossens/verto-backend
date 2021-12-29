package com.verto.controller;

import com.verto.model.TranslationModel;
import com.verto.service.TranslationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping ("")
    public String list() {
        return "list";
    }

    @PostMapping("/create")
    public TranslationModel create(@RequestBody TranslationModel translation) {
        this.translationService.insertIntoDatabase(translation);
        return new TranslationModel(translation.getId(), translation.getValue(), translation.getLabelId(), translation.getLanguageId());
    }

    @GetMapping("/get")
    public String get() {
        return "get";
    }
    
}
