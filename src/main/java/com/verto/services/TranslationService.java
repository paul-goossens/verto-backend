package com.verto.services;

import com.verto.mappers.TranslationRowMapper;
import com.verto.models.TranslationModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TranslationService {

    private final JdbcTemplate jdbcTemplate;

    public TranslationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertIntoDatabase(TranslationModel t) {
        return jdbcTemplate.update(
                "INSERT INTO translations(guid, key, value, is_group, language_guid) VALUES (?, ?, ?, ?, ?)",
                t.getGuid(),
                t.getKey(),
                t.getValue(),
                t.getIsGroup(),
                t.getLanguageGuid()
        );
    }

    public List<TranslationModel> selectAllFromDatabase(String languageGuid) {
        return jdbcTemplate.query(
                "SELECT * FROM translations WHERE language_guid = '" + languageGuid + "'",
                new TranslationRowMapper()
        );
    }

}
