package main.java.test.Bean;

import javax.sql.DataSource;

public interface userDao {
    public void setDataSource(DataSource dataSource);
    public void addUser(user u);
    public void deleteUser(user u);
    public void updateUser(user u);
    public String getPassword(String user_account);
    public boolean existUser(String user_account);
}
