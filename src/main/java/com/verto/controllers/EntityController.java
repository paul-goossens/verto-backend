package com.verto.controllers;

import com.verto.models.EntityModel;
import com.verto.services.LanguageService;
import com.verto.services.EntityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/entities")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class EntityController {

    private final EntityService entityService;
    private final LanguageService languageService;

    public EntityController(EntityService entityService, LanguageService languageService) {
        this.entityService = entityService;
        this.languageService = languageService;
    }

    @GetMapping("")
    public List<EntityModel> list() {
        return this.entityService.selectAllFromDatabase();
    }

//    @GetMapping("/{id}")
//    public EntityModel get(@PathVariable("id") String id) {
//        return this.entityService.selectFromDatabase(id);
//    }

//    @PostMapping("/create")
//    public EntityModel create(@RequestBody EntityModel t) throws Exception {
//        String id = UUID.randomUUID().toString();
//        t.setId(id);
//
//        if (t.getIsGroup() == null) {
//            t.setIsGroup(false);
//        }
//
//        if (t.getIsGroup() && t.getValue() != null) {
//            throw new Exception("Property 'value' must equal 'null' when 'isGroup' equals 'true'");
//        }
//
//        if (t.getLanguageId() == null) {
//            throw new Exception("Property 'languageId' is required.");
//        }
//
//        String languageId = t.getLanguageId();
//        Boolean isValid = this.languageService.isValid(languageId);
//        if (!isValid) {
//            throw new Exception(("Property 'languageId' is invalid."));
//        }
//
//        Boolean isDuplicate = this.entityService.isDuplicate(t);
//        if (isDuplicate) {
//            throw new Exception("The combination of 'key' and 'languageId' already exist.");
//        }
//
//        this.entityService.insertIntoDatabase(t);
//
//        return new EntityModel(
//                t.getId(),
//                t.getKey(),
//                t.getValue(),
//                t.getIsGroup(),
//                t.getLanguageId()
//        );
//    }

//    @PatchMapping("/{id}")
//    public void update(@PathVariable("id") String id, @RequestBody EntityModel t) {
//        t.setId(id);
//        this.entityService.updateInDatabase(t);
//    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") String id) {
//        this.entityService.deleteFromDatabase(id);
//    }

}
