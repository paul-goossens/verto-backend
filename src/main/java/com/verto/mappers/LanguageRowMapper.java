package com.verto.mappers;

import com.verto.models.LanguageModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageRowMapper implements RowMapper<LanguageModel> {
    @Override
    public LanguageModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        LanguageModel l = new LanguageModel(
                rs.getString("id"),
                rs.getString("name")
        );

        return l;
    }
}
