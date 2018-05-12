package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.EduInfoDao;
import com.resumeweb.entity.EduInfo;
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
public class EduInfoDaoImp implements EduInfoDao {
    private JdbcTemplate jdbcTemplateObject;

    public EduInfoDaoImp() {
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public int addEduInfo(final EduInfo eduInfo) {
        final String sql="INSERT INTO edu_info(user_id, start_date, end_date, school, major, edu, rank) " +
                "VALUES(?,?,?,?,?,?,?) ";
        KeyHolder keyHolder=new GeneratedKeyHolder();
//        jdbcTemplateObject.update(sql,eduInfo.getUserId(),eduInfo.getStartDate()
//        ,eduInfo.getEndDate(),eduInfo.getSchool(),eduInfo.getMajor(),eduInfo.getEdu()
//        ,eduInfo.getRank(),keyHolder);
        jdbcTemplateObject.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1,eduInfo.getUserId());
                ps.setDate(2,eduInfo.getStartDate());
                ps.setDate(3,eduInfo.getEndDate());
                ps.setString(4,eduInfo.getSchool());
                ps.setString(5,eduInfo.getMajor());
                ps.setString(6,eduInfo.getEdu());
                ps.setString(7,eduInfo.getRank());
                return ps;

            }
        },keyHolder);
        return keyHolder.getKey().intValue();

    }

    @Override
    public void updateEduInfo(EduInfo eduInfo) {
        String sql="UPDATE edu_info set user_id=?,start_date=?,end_date=?" +
                ",school=?,major=?,edu=?,rank=?";
        jdbcTemplateObject.update(sql,eduInfo.getUserId(),eduInfo.getStartDate()
                ,eduInfo.getEndDate(),eduInfo.getSchool(),eduInfo.getMajor(),eduInfo.getEdu()
                ,eduInfo.getRank());
    }

    @Override
    public void deleteEduInfo(EduInfo eduInfo) {
       String sql="DELETE FROM edu_info WHERE edu_info_id=?";
       jdbcTemplateObject.update(sql,eduInfo.getEduInfoId());
    }

    @Override
    public EduInfo getEduInfo(int edu_info_id) {
        String sql="SELECT * FROM edu_info WHERE edu_info_id=?";
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
        },edu_info_id);
    }
}
