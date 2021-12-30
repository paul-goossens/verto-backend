package com.verto.service;

import com.verto.model.TranslationModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TranslationService {

    private final JdbcTemplate jdbcTemplate;

    public TranslationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertIntoDatabase(TranslationModel t) {
        String sql = """
                INSERT INTO translations(guid, key, value, is_group, language_guid) VALUES (?, ?, ?, ?, ?);
                """;
        return jdbcTemplate.update(sql, t.getGuid(), t.getKey(), t.getValue(), t.getIsGroup(), t.getLanguageGuid());
    }

}
