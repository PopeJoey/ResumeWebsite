package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.PatternDao;
import com.resumeweb.entity.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatternDaoImp implements PatternDao {
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Pattern> getPatternList() {
        String sql = "SELECT * FROM pattern";
        return jdbcTemplateObject.query(sql, new RowMapper<Pattern>() {
            @Override
            public Pattern mapRow(ResultSet resultSet, int i) throws SQLException {
                Pattern pattern = new Pattern();
                pattern.setPatternId(resultSet.getInt(1));
                pattern.setPatternName(resultSet.getString(2));
                pattern.setPatternPath(resultSet.getString(3));
                pattern.setPatternClass(resultSet.getString(4));
                pattern.setPatternPreviewPic(resultSet.getString(5));
                pattern.setPatternInfo(resultSet.getString(6));
                return pattern;
            }
        });
    }
}
