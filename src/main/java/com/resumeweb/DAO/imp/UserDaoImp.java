package com.resumeweb.DAO.imp;

import com.resumeweb.DAO.UserDao;
import com.resumeweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserDaoImp implements UserDao {

    private JdbcTemplate jdbcTemplateObject;
    public UserDaoImp() {

    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public int addUser(final User u) {
//        String sql = "INSERT INTO user(user_account,password,email)VALUES(?,?,?)";
//        KeyHolder keyHolder=new GeneratedKeyHolder();
//        jdbcTemplateObject.update(sql,u.getUserAccount(),u.getPassword(),u.getEmail(),keyHolder);
//        return keyHolder.getKey().intValue();
        final String sql = "INSERT INTO user(user_account,password,email)VALUES(?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();
        jdbcTemplateObject.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1,u.getUserAccount());
                ps.setString(2,u.getPassword());
                ps.setString(3,u.getEmail());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public void deleteUser(User u) {
        String sql="DELETE FROM user WHERE user_account=?";
        jdbcTemplateObject.update(sql,u.getUserAccount());
    }

    @Override
    public void updateUser(User u) {
        String sql="UPDATE user set user_account=?,password=?,email=?";
        jdbcTemplateObject.update(sql,u.getUserAccount(),u.getPassword(),u.getEmail());
    }

    @Override
    public String getPassword(String user_account) {
        String sql="SELECT password FROM user WHERE user_account=?";
        String password=jdbcTemplateObject.queryForObject(sql,new Object[]{user_account},String.class);
        return password;
    }


    @Override
    public boolean existUser(String user_account) {
        String sql="SELECT password FROM user WHERE user_account=?";
        try{
            String password= jdbcTemplateObject.queryForObject(sql,new Object[]{user_account},String.class
            );

        }catch (DataAccessException e){
            return false;
        }

        return true;
    }

    @Override
    public int getUserId(String account) {
        String sql="SELECT user_id FROM user WHERE user_account=?";
        int user_id= jdbcTemplateObject.queryForObject(sql,new Object[]{account},Integer.class);
        return user_id;
    }
}
