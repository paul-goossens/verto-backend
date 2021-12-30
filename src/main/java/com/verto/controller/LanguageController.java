package com.verto.controller;

import com.verto.model.LanguageModel;
import com.verto.model.TranslationModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @PostMapping("/create")
    public LanguageModel create(@RequestBody LanguageModel t) {
        String guid = UUID.randomUUID().toString();
        t.setGuid(guid);
        // this.translationService.insertIntoDatabase(t);
        return new LanguageModel(t.getGuid(), t.getValue());
    }

}
