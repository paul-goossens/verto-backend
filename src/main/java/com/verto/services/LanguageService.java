package com.verto.services;

import com.verto.mappers.LanguageRowMapper;
import com.verto.models.LanguageModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LanguageService {

    private final JdbcTemplate jdbcTemplate;

    public LanguageService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertIntoDatabase(LanguageModel l) {
        String sql = """
                INSERT INTO languages(guid, value) VALUES (?, ?);
                """;
        return jdbcTemplate.update(sql, l.getGuid(), l.getValue());
    }

    public LanguageModel selectFromDatabase(String guid) throws DataAccessException {
        String sql = """
                SELECT guid, value FROM languages WHERE guid = ?;
                """;
        return jdbcTemplate.queryForObject(sql, new LanguageRowMapper(), guid);
    }

    public List<LanguageModel> selectAllFromDatabase() {
        return jdbcTemplate.query("SELECT * FROM languages", new LanguageRowMapper());
    }

}
