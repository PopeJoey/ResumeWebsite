package main.java.test.Bean;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userMapper implements RowMapper<user> {

    @Override
    public user mapRow(ResultSet resultSet, int i) throws SQLException {
        user u=new user();
        u.setUser_id(resultSet.getInt("user_id"));
        u.setUser_account(resultSet.getString("user_account"));
        u.setPassword(resultSet.getString("password"));
        u.setEmail(resultSet.getString("email"));
        return u;
    }
}
