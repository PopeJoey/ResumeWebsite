package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.ResumeProjectsDao;
import com.resumeweb.entity.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ResumeProjectsDaoImp implements ResumeProjectsDao{

    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public int addResume_projects(int resume_id,int project_info_id){
        String sql="INSERT INTO resume_projects(resume_id, project_info_id)" +
                "VALUES (?,?)";
        jdbcTemplateObject.update(sql,resume_id,project_info_id);
        return 1;
    }

    public void deleteResume_projects(int resume_id,int project_info_id){
        String sql="DELETE from resume_projects WHERE resume_id=?and project_info_id=?";
        jdbcTemplateObject.update(sql,resume_id, project_info_id);
    }

    public List<Integer> getProject_info_ids(int resume_id){
       String sql="SELECT project_info_id FROM resume_projects WHERE resume_id=?";
       return jdbcTemplateObject.query(sql, new RowMapper<Integer>() {
           @Override
           public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
               return resultSet.getInt(1);
           }
       },resume_id);
    }
}
