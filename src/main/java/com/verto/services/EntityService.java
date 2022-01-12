package com.verto.services;

import com.verto.mappers.EntityRowMapper;
import com.verto.models.EntityModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntityService {

    private final JdbcTemplate jdbcTemplate;

    public EntityService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public Integer insertIntoDatabase(EntityModel t) {
//        return jdbcTemplate.update(
//                "INSERT INTO translations(guid, key, value, is_group, language_guid) VALUES (?, ?, ?, ?, ?)",
//                t.getGuid(),
//                t.getKey(),
//                t.getValue(),
//                t.getIsGroup(),
//                t.getLanguageGuid()
//        );
//    }

    public List<EntityModel> selectAllFromDatabase() {
        String sql = """
                SELECT 
                    entities.id, 
                    entities.member_of, 
                    entities.is_group, 
                    entities.language_key_id, 
                    language_keys.language_key, 
                    entities.translation_key_id, 
                    translation_keys.translation_key, 
                    entities.translation_value_id, 
                    translation_values.translation_value
                FROM 
                    entities
                INNER JOIN 
                    language_keys ON entities.language_key_id = language_keys.id
                INNER JOIN 
                    translation_keys ON entities.translation_key_id = translation_keys.id
                INNER JOIN 
                    translation_values ON entities.translation_value_id = translation_values.id
                """;
        return jdbcTemplate.query(
                sql,
                new EntityRowMapper()
        );
    }

//    public EntityModel selectFromDatabase(String guid) {
//        return jdbcTemplate.queryForObject(
//                "SELECT * FROM translations WHERE guid = ?",
//                new EntityRowMapper(),
//                guid
//        );
//    }

//    public Boolean deleteFromDatabase(String guid) {
//        int count = jdbcTemplate.update(
//                "DELETE FROM translations WHERE guid = ?",
//                guid
//        );
//
//        return count >= 1;
//    }

//    public Boolean updateInDatabase(EntityModel t) {
//        String sql = "";
//
//        if (t.getKey() != null) {
//            sql += "key = '" + t.getKey() + "', ";
//        }
//
//        if (t.getValue() != null) {
//            sql += "value = '" + t.getValue() + "', ";
//        }
//
//        sql = sql.substring(0, sql.length() - 2);
//        sql = "UPDATE translations SET " + sql + " WHERE guid = '" + t.getGuid() + "'";
//        int count = jdbcTemplate.update(sql);
//
//        return count >= 1;
//    }

//    public Boolean isDuplicate(EntityModel t) {
//        Integer count = jdbcTemplate.queryForObject(
//                "SELECT COUNT(*) FROM translations WHERE key = ? AND language_guid = ?",
//                Integer.class,
//                t.getKey(),
//                t.getLanguageGuid()
//        );
//
//        return count != null && count >= 1;
//    }

}
