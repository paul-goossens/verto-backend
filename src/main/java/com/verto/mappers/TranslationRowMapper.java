package com.verto.mappers;

import com.verto.models.TranslationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TranslationRowMapper implements RowMapper<TranslationModel> {
    @Override
    public TranslationModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new TranslationModel(
                rs.getString("guid"),
                rs.getString("key"),
                rs.getString("value"),
                rs.getBoolean("is_group"),
                rs.getString("language_guid")
        );
    }
}
