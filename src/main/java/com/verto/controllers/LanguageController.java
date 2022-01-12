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
        String id = UUID.randomUUID().toString();
        l.setId(id);
        this.languageService.insertIntoDatabase(l);
        return new LanguageModel(l.getId(), l.getName());
    }

    @GetMapping("/{id}")
    public LanguageModel get(@PathVariable("id") String id) {
        return this.languageService.selectFromDatabase(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") String id, @RequestBody LanguageModel l) {
        this.languageService.updateInDatabase(id, l.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.languageService.deleteFromDatabase(id);
    }

}
