package main.java.test.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
@Repository
public class userDaoImp implements userDao {

    private JdbcTemplate jdbcTemplateObject;
    public userDaoImp() {

    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void addUser(user u) {
        String sql = "INSERT INTO user(user_account,password,email)VALUES(?,?,?)";
        jdbcTemplateObject.update(sql,u.getUser_account(),u.getPassword(),u.getEmail());
    }

    @Override
    public void deleteUser(user u) {
        String sql="DELETE FROM user WHERE user_account=?";
        jdbcTemplateObject.update(sql,u.getUser_account());
    }

    @Override
    public void updateUser(user u) {
        String sql="UPDATE user set user_account=?,password=?,email=?";
        jdbcTemplateObject.update(sql,u.getUser_account(),u.getPassword(),u.getEmail());
    }

    @Override
    public String getPassword(String user_account) {
        String sql="SELECT password FROM user WHERE user_account=?";
        String password=jdbcTemplateObject.queryForObject(sql,new Object[]{user_account},String.class);
        return password;
    }


    @Override
    public boolean existUser(String user_account) {
        String sql="SELECT * FROM user WHERE user_account=?";
        try{
            user u= jdbcTemplateObject.queryForObject(sql,new Object[]{user_account},new userMapper());

        }catch (DataAccessException e){
            return false;
        }

        return true;
    }
}
