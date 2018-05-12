package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.ResumeEdusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResumeEdusDaoImp implements ResumeEdusDao{
    private JdbcTemplate jdbcTemplateObject;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public int addResumeEdus(int resume_id,int edu_info_id){
        String sql="INSERT INTO resume_edus(resume_id, edu_info_id) VALUES (?,?)";
        jdbcTemplateObject.update(sql,resume_id,edu_info_id);
        return 1;
    }
    public void deleteResumeEdus(int resume_id,int edu_info_id){
        String sql="DELETE FROM resume_edus WHERE resume_id=? and edu_info_id = ?";
        jdbcTemplateObject.update(sql,resume_id,edu_info_id);
    }
    public List<Integer> getEduInfoIds(int resume_id){
        String sql="SELECT edu_info_id from resume_edus WHERE resume_id=?";
        return jdbcTemplateObject.query(sql, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getInt(2);
            }
        },resume_id);
    }
}
