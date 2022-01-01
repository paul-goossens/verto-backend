package com.verto.controllers;

import com.verto.models.TranslationModel;
import com.verto.services.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/translations")
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

        this.translationService.insertIntoDatabase(t);

        return new TranslationModel(
                t.getGuid(),
                t.getKey(),
                t.getValue(),
                t.getIsGroup(),
                t.getLanguageGuid()
        );
    }

    @PatchMapping("/{guid}")
    public void update(@PathVariable("guid") String guid, @RequestBody TranslationModel t) {
        t.setGuid(guid);
        this.translationService.updateInDatabase(t);
    }

    @DeleteMapping("/{guid}")
    public void delete(@PathVariable("guid") String guid) {
        this.translationService.deleteFromDatabase(guid);
    }

}
