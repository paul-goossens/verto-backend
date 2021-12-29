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

    public int insertIntoDatabase(TranslationModel translation) {
        String sql = """
                INSERT INTO translations(value, label_id, language_id) VALUES (?, ?, ?);
                """;
        return jdbcTemplate.update(sql, translation.getValue(), translation.getLabelId(), translation.getLanguageId());
    }

}
