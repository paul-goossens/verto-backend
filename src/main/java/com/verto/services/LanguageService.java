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
                "INSERT INTO languages(id, name) VALUES (?, ?);",
                l.getId(),
                l.getName()
        );
    }

    public List<LanguageModel> selectAllFromDatabase() {
        return jdbcTemplate.query(
                "SELECT * FROM languages",
                new LanguageRowMapper()
        );
    }

    public LanguageModel selectFromDatabase(String id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM languages WHERE id = ?",
                new LanguageRowMapper(),
                id
        );
    }

    public Boolean updateInDatabase(String id, String name) {
        int count = jdbcTemplate.update(
                "UPDATE languages SET value = ? WHERE id = ?",
                name,
                id
        );

        return count >= 1;
    }

    public Boolean deleteFromDatabase(String id) {
        int count = jdbcTemplate.update(
                "DELETE FROM languages WHERE id = ?",
                id
        );

        return count == 1;
    }

    public Boolean isValid(String id) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM languages WHERE id = ?",
                Integer.class,
                id
        );

        return count != null && count >= 1;
    }

}
