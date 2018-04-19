package main.java.test.Bean;

public class user {
    private int user_id;
    private String user_account;
    private String password;
    private String email;

    public user(int user_id, String user_account, String password, String email) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.password = password;
        this.email = email;
    }

    public user(String user_account, String password, String email) {
        this.user_account = user_account;
        this.password = password;
        this.email = email;
    }

    public user() {
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
