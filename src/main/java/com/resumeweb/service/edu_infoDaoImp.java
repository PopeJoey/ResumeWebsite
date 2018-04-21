package com.resumeweb.service;

import com.resumeweb.entity.EduInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class edu_infoDaoImp implements edu_infoDao {
    private JdbcTemplate jdbcTemplateObject;

    public edu_infoDaoImp() {
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public void addEduInfo(EduInfo eduInfo) {
        String sql="INSERT INTO edu_info(user_id, start_date, end_date, school, major, edu, rank) " +
                "VALUES(?,?,?,?,?,?,?) ";
        jdbcTemplateObject.update(sql,eduInfo.getUserId(),eduInfo.getStartDate()
        ,eduInfo.getEndDate(),eduInfo.getSchool(),eduInfo.getMajor(),eduInfo.getEdu()
        ,eduInfo.getRank());

    }

    @Override
    public void updateEduInfo(EduInfo eduInfo) {
        String sql="UPDATE edu_info set user_id=?,start_date?,end_date=?" +
                ",school=?,major=?,edu=?,rank=?";
        jdbcTemplateObject.update(sql,eduInfo.getUserId(),eduInfo.getStartDate()
                ,eduInfo.getEndDate(),eduInfo.getSchool(),eduInfo.getMajor(),eduInfo.getEdu()
                ,eduInfo.getRank());
    }

    @Override
    public void deleteEduInfo(EduInfo eduInfo) {
       String sql="DELETE FROM edu_info WHERE user_id=?";
       jdbcTemplateObject.update(sql,eduInfo.getUserId());
    }

    @Override
    public EduInfo getEduInfo(int user_id) {
        String sql="";
        return jdbcTemplateObject.queryForObject(sql, new RowMapper<EduInfo>() {
            @Override
            public EduInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                EduInfo eduInfo=new EduInfo();
                eduInfo.setEduInfoId(resultSet.getInt(1));
                eduInfo.setUserId(resultSet.getInt(2));
                eduInfo.setStartDate(resultSet.getDate(3));
                eduInfo.setEndDate(resultSet.getDate(4));
                eduInfo.setSchool(resultSet.getString(5));
                eduInfo.setMajor(resultSet.getString(6));
                eduInfo.setEdu(resultSet.getString(7));
                eduInfo.setRank(resultSet.getString(8));
                return eduInfo;
            }
        },user_id);
    }
}
