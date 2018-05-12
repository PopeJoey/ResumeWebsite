package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.ProjectInfoDao;
import com.resumeweb.entity.ProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProjectInfoDaoImp implements ProjectInfoDao {
    private JdbcTemplate jdbcTemplateObject;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public int addProjectInfo(final ProjectInfo projectInfo) {
       final String sql="INSERT INTO project_info(user_id, pro_or_intern, " +
                "project_name, start_date, end_date, description) VALUES (?,?,?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
//        jdbcTemplateObject.update(sql,projectInfo.getUserId(),projectInfo.getProOrIntern()
//        ,projectInfo.getProjectName(),projectInfo.getStartDate(),projectInfo.getEndDate(),projectInfo.getDescription(),keyHolder);
        jdbcTemplateObject.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1,projectInfo.getUserId());
                ps.setString(2,projectInfo.getProOrIntern());
                ps.setString(3,projectInfo.getProjectName());
                ps.setDate(4,projectInfo.getStartDate());
                ps.setDate(5,projectInfo.getEndDate());
                ps.setString(6,projectInfo.getDescription());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void deleteProjectInfo(ProjectInfo projectInfo) {
        String sql="DELETE FROM project_info WHERE project_info_id=?";
        jdbcTemplateObject.update(sql,projectInfo.getProjectInfoId());
    }

    @Override
    public void updateProjectInfo(ProjectInfo projectInfo) {
        String sql="UPDATE project_info SET user_id=?,pro_or_intern=?,project_name=?" +
                ",start_date=?,end_date=?,description=?";
        jdbcTemplateObject.update(sql,projectInfo.getUserId(),projectInfo.getProOrIntern()
        ,projectInfo.getProjectName(),projectInfo.getStartDate(),projectInfo.getEndDate()
        ,projectInfo.getDescription());
    }

    @Override
    public ProjectInfo getProjectInfo(int project_info_id) {
        String sql="SELECT * FROM  project_info WHERE project_info_id=?";
        return jdbcTemplateObject.queryForObject(sql, new RowMapper<ProjectInfo>() {
            @Override
            public ProjectInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                ProjectInfo p=new ProjectInfo();
                p.setProjectInfoId(resultSet.getInt(1));
                p.setUserId(resultSet.getInt(2));
                p.setProOrIntern(resultSet.getString(3));
                p.setProjectName(resultSet.getString(4));
                p.setStartDate(resultSet.getDate(5));
                p.setEndDate(resultSet.getDate(6));
                p.setDescription(resultSet.getString(7));
                return p;
            }
        },project_info_id);
    }
}
