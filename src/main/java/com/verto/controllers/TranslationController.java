package com.verto.controllers;

import com.verto.models.TranslationModel;
import com.verto.services.LanguageService;
import com.verto.services.TranslationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    private final TranslationService translationService;
    private final LanguageService languageService;

    public TranslationController(TranslationService translationService, LanguageService languageService) {
        this.translationService = translationService;
        this.languageService = languageService;
    }

    @GetMapping("/{languageGuid}/language")
    public List<TranslationModel> list(@PathVariable("languageGuid") String languageGuid) {
        return this.translationService.selectAllFromDatabase(languageGuid);
    }

    @GetMapping("/{guid}")
    public TranslationModel get(@PathVariable("guid") String guid) {
        return this.translationService.selectFromDatabase(guid);
    }

    @PostMapping("/create")
    public TranslationModel create(@RequestBody TranslationModel t) throws Exception {
        String guid = UUID.randomUUID().toString();
        t.setGuid(guid);

        if (t.getIsGroup() == null) {
            t.setIsGroup(false);
        }

        if (t.getIsGroup() && t.getValue() != null) {
            throw new Exception("Property 'value' must equal 'null' when 'isGroup' equals 'true'");
        }

        if (t.getLanguageGuid() == null) {
            throw new Exception("Property 'languageGuid' is required.");
        }

        String languageGuid = t.getLanguageGuid();
        Boolean isValid = this.languageService.isValid(languageGuid);
        if (!isValid) {
            throw new Exception(("Property 'languageGuid' is invalid."));
        }

        Boolean isDuplicate = this.translationService.isDuplicate(t);
        if (isDuplicate) {
            throw new Exception("The combination of 'key' and 'languageGuid' already exist.");
        }

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
