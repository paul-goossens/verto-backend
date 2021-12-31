package com.verto.controllers;

import com.verto.models.LanguageModel;
import com.verto.models.TranslationModel;
import com.verto.services.LanguageService;
import com.verto.services.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private final TranslationService translationService;
    private final LanguageService languageService;

    public TranslationController(TranslationService translationService, LanguageService languageService) {
        this.translationService = translationService;
        this.languageService = languageService;
    }

    @GetMapping("/{languageGuid}")
    public List<TranslationModel> list(@PathVariable("languageGuid") String languageGuid) {
        return this.translationService.selectAllFromDatabase(languageGuid);
    }

    @PostMapping("/create")
    public TranslationModel create(@RequestBody TranslationModel t) {
        String guid = UUID.randomUUID().toString();
        t.setGuid(guid);
        t.setIsGroup(false);
        this.translationService.insertIntoDatabase(t);

        return new TranslationModel(
                t.getGuid(),
                t.getKey(),
                t.getValue(),
                t.getIsGroup(),
                t.getLanguageGuid()
        );
    }

}
