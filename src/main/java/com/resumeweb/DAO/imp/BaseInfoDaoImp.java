package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.BaseInfoDao;
import com.resumeweb.entity.BaseInfo;
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
public class BaseInfoDaoImp implements BaseInfoDao {
    private JdbcTemplate jdbcTemplateObject;

    public BaseInfoDaoImp() {
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public int addBaseInfo(final BaseInfo baseInfo) {
      final   String sql="INSERT INTO base_info(user_id, name, gender, birth_date, " +
                "highest_edu, phone_number, country, image_path, id_number," +
                " marriage_status, ethnic_group, email, simple_introduction) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
//        jdbcTemplateObject.update(sql,baseInfo.getUserId(),baseInfo.getName(),baseInfo.getGender(),baseInfo.getBirthDate()
//        ,baseInfo.getHighestEdu(),baseInfo.getPhoneNumber(),baseInfo.getCountry(),baseInfo.getImagePath(),baseInfo.getIdNumber()
//        ,baseInfo.getMarriageStatus(),baseInfo.getEthnicGroup(),baseInfo.getEmail(),baseInfo.getSimpleIntroduction()
//        ,keyHolder);
        jdbcTemplateObject.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1,baseInfo.getUserId());
                ps.setString(2,baseInfo.getName());
                ps.setString(3,baseInfo.getGender());
                ps.setString(4,baseInfo.getBirthDate());
                ps.setString(5,baseInfo.getHighestEdu());
                ps.setString(6,baseInfo.getPhoneNumber());
                ps.setString(7,baseInfo.getCountry());
                ps.setString(8,baseInfo.getImagePath());
                ps.setString(9,baseInfo.getIdNumber());
                ps.setString(10,baseInfo.getMarriageStatus());
                ps.setString(11,baseInfo.getEthnicGroup());
                ps.setString(12,baseInfo.getEmail());
                ps.setString(13,baseInfo.getSimpleIntroduction());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
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
       String sql="DELETE FROM base_info WHERE baseinfo_id=?";
       jdbcTemplateObject.update(sql,baseInfo.getBaseInfoId());
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
