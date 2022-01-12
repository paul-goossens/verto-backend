package com.verto.mappers;

import com.verto.models.EntityModel;
import com.verto.models.LanguageModel;
import com.verto.models.TranslationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntityRowMapper implements RowMapper<EntityModel> {
    @Override
    public EntityModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        LanguageModel language = new LanguageModel(
                rs.getString("language_key_id"),
                rs.getString("language_key")
        );

        TranslationModel translation = new TranslationModel(
                rs.getString("translation_key_id"),
                rs.getString("translation_key"),
                rs.getString("translation_value_id"),
                rs.getString("translation_value")
        );

        return new EntityModel(
                rs.getString("id"),
                rs.getString("member_of"),
                rs.getBoolean("is_group"),
                language,
                translation
        );
    }
}
