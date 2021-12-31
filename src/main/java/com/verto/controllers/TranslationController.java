package com.verto.controllers;

import com.verto.models.TranslationModel;
import com.verto.services.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/translations")
public class TranslationController {

    private final TranslationService translationService;

    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/{languageGuid}")
    public List<TranslationModel> list(@PathVariable("languageGuid") String languageGuid) {
        return this.translationService.selectAllFromDatabase(languageGuid);
    }

    @PostMapping("/create")
    public TranslationModel create(@RequestBody TranslationModel t) throws Exception {
        String guid = UUID.randomUUID().toString();
        t.setGuid(guid);
        t.setIsGroup(false);

        Integer insert = this.translationService.insertIntoDatabase(t);

        return new TranslationModel(
                t.getGuid(),
                t.getKey(),
                t.getValue(),
                t.getIsGroup(),
                t.getLanguageGuid()
        );
    }

}
