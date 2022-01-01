package com.verto.services;

import com.verto.mappers.LanguageRowMapper;
import com.verto.models.LanguageModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageService {

    private final JdbcTemplate jdbcTemplate;

    public LanguageService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Integer insertIntoDatabase(LanguageModel l) {
        return jdbcTemplate.update(
                "INSERT INTO languages(guid, value) VALUES (?, ?);",
                l.getGuid(),
                l.getValue()
        );
    }

    public LanguageModel selectFromDatabase(String guid) {
        return jdbcTemplate.queryForObject(
                "SELECT guid, value FROM languages WHERE guid = ?",
                new LanguageRowMapper(),
                guid
        );
    }

    public List<LanguageModel> selectAllFromDatabase() {
        return jdbcTemplate.query(
                "SELECT * FROM languages",
                new LanguageRowMapper()
        );
    }

    public Boolean updateInDatabase(String guid, String value) {
        int count = jdbcTemplate.update(
                "UPDATE languages SET value = ? WHERE guid = ?",
                value,
                guid
        );

        return count >= 1;
    }

    public Boolean deleteFromDatabase(String guid) {
        int count = jdbcTemplate.update(
                "DELETE FROM languages WHERE guid = ?",
                guid
        );

        return count == 1;
    }

}
