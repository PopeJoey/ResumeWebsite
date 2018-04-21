package com.resumeweb.service;

import com.resumeweb.entity.BaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class base_infoDaoImp implements base_infoDao {
    private JdbcTemplate jdbcTemplateObject;

    public base_infoDaoImp() {
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public void addBaseInfo(BaseInfo baseInfo) {
        String sql="INSERT INTO base_info(user_id, name, gender, birth_date, " +
                "highest_edu, phone_number, country, image_path, id_number," +
                " marriage_status, ethnic_group, email, simple_introduction) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,)";
        jdbcTemplateObject.update(sql,baseInfo.getUserId(),baseInfo.getName(),baseInfo.getGender(),baseInfo.getBirthDate()
        ,baseInfo.getHighestEdu(),baseInfo.getPhoneNumber(),baseInfo.getCountry(),baseInfo.getImagePath(),baseInfo.getIdNumber()
        ,baseInfo.getMarriageStatus(),baseInfo.getEthnicGroup(),baseInfo.getEmail(),baseInfo.getSimpleIntroduction()
        );
    }

    @Override
    public void updateBaseInfo(BaseInfo baseInfo) {
       String sql="UPDATE base_info SET user_id=?,name=?,gender=?,birth_date=?" +
               ",highest_edu=?,phone_number=?,country=?,image_path=?,id_number=?" +
               ",marriage_status=?,ethnic_group=?,email=?,simple_introduction=?";
        jdbcTemplateObject.update(sql,baseInfo.getUserId(),baseInfo.getName(),baseInfo.getGender(),baseInfo.getBirthDate()
                ,baseInfo.getHighestEdu(),baseInfo.getPhoneNumber(),baseInfo.getCountry(),baseInfo.getImagePath(),baseInfo.getIdNumber()
                ,baseInfo.getMarriageStatus(),baseInfo.getEthnicGroup(),baseInfo.getEmail(),baseInfo.getSimpleIntroduction()
        );
    }

    @Override
    public void deleteBaseInfo(BaseInfo baseInfo) {
       String sql="DELETE FROM base_info WHERE user_id=?";
       jdbcTemplateObject.update(sql,baseInfo.getUserId());
    }

    @Override
    public BaseInfo getBaseInfo(int user_id) {
        String sql="SELECT * FROM  base_info WHERE user_id=? ";
        return jdbcTemplateObject.queryForObject(sql, new RowMapper<BaseInfo>() {
            @Override
            public BaseInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                BaseInfo baseInfo=new BaseInfo();
                baseInfo.setBaseInfoId(resultSet.getInt("baseinfo_id"));
                baseInfo.setUserId(resultSet.getInt("user_id"));
                baseInfo.setName(resultSet.getString("name"));
                baseInfo.setGender(resultSet.getString("gender"));
                baseInfo.setBirthDate(resultSet.getString("birth_date"));
                baseInfo.setHighestEdu(resultSet.getString("highest_edu"));
                baseInfo.setPhoneNumber(resultSet.getString("phone_number"));
                baseInfo.setCountry(resultSet.getString("country"));
                baseInfo.setImagePath(resultSet.getString("image_path"));
                baseInfo.setIdNumber(resultSet.getString("id_number"));
                baseInfo.setMarriageStatus(resultSet.getString("marriage_status"));
                baseInfo.setEthnicGroup(resultSet.getString("ethnic_group"));
                baseInfo.setEmail(resultSet.getString("email"));
                baseInfo.setSimpleIntroduction(resultSet.getString("simple_introduction"));
                return baseInfo;
            }
        },user_id);
    }
}
