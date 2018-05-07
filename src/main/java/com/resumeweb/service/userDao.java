package  com.resumeweb.service;
import com.resumeweb.entity.User;
import javax.sql.DataSource;

public interface userDao {
    public void setDataSource(DataSource dataSource);
    public void addUser(User u);
    public void deleteUser(User u);
    public void updateUser(User u);
    public String getPassword(String user_account);
    public boolean existUser(String user_account);
    public int getUserId(String account);
}
