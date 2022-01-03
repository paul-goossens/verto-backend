package com.verto.controllers;

import com.verto.models.LanguageModel;
import com.verto.services.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("")
    public List<LanguageModel> list() {
        return this.languageService.selectAllFromDatabase();
    }

    @PostMapping("/create")
    public LanguageModel create(@RequestBody LanguageModel l) {
        String guid = UUID.randomUUID().toString();
        l.setGuid(guid);
        this.languageService.insertIntoDatabase(l);
        return new LanguageModel(l.getGuid(), l.getValue());
    }

    @GetMapping("/{guid}")
    public LanguageModel get(@PathVariable("guid") String guid) {
        return this.languageService.selectFromDatabase(guid);
    }

    @PatchMapping("/{guid}")
    public void update(@PathVariable("guid") String guid, @RequestBody LanguageModel l) {
        this.languageService.updateInDatabase(guid, l.getValue());
    }

    @DeleteMapping("/{guid}")
    public void delete(@PathVariable("guid") String guid) {
        this.languageService.deleteFromDatabase(guid);
    }

}
