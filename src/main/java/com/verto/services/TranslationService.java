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

    public Integer insertIntoDatabase(TranslationModel t) throws Exception {
        Boolean isDuplicate = this.isDuplicate(t);

        if (isDuplicate) {
            throw new Exception("The combination of 'key' and 'languageGuid' already exist.");
        }

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

    public TranslationModel selectFromDatabase(String guid) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM translations WHERE guid = ?",
                new TranslationRowMapper(),
                guid
        );
    }

    public Boolean deleteFromDatabase(String guid) {
        int count = jdbcTemplate.update(
                "DELETE FROM translations WHERE guid = ?",
                guid
        );

        return count >= 1;
    }

    public Boolean updateInDatabase(TranslationModel t) {
        String sql = "";

        if (t.getKey() != null) {
            System.out.println(t.getKey());
            sql += "key = '" + t.getKey() + "', ";
        }

        if (t.getValue() != null) {
            System.out.println(t.getValue());
            sql += "value = '" + t.getValue() + "', ";
        }

        sql = sql.substring(0, sql.length() - 2);
        sql = "UPDATE translations SET " + sql + " WHERE guid = '" + t.getGuid() + "'";
        int count = jdbcTemplate.update(sql);

        return count >= 1;
    }

    private Boolean isDuplicate(TranslationModel t) {
        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM translations WHERE key = ? AND language_guid = ?",
                Integer.class,
                t.getKey(),
                t.getLanguageGuid()
        );

        return count != null && count >= 1;
    }

}
