package main.java.test.Bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.rmi.runtime.Log;

import java.sql.*;

public class ConnectBean {
    private String driver="com.mysql.jdbc.Driver";//默认驱动程序；
    private String jdbcurl="jdbc:mysql://119.29.163.251:3306/resumesys";//jdbcurl
    private String userName="resumeroot";//用户名
    private String password="helloworld";//密码
    private Connection connection=null;
    public ConnectBean() {
        connection =getConnection();

    }
    public Connection getConnection() {
        try{
            Class.forName(driver);//注册驱动程序;
            connection= DriverManager.getConnection(jdbcurl+"?useSSL=false" , userName, password);//建立连接；
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }catch(SQLException e2){
            e2.printStackTrace();
        }
        return connection;
    }
    public void closeConnection(Connection connection) {//关闭连接；
        try {
            if (connection != null)
                connection.close();
            connection = null;
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        ConnectBean connectBean=new ConnectBean();
//        Connection conn=connectBean.getConnection();
//        try {
//            Statement stmt=conn.createStatement();
//            ResultSet rs= stmt.executeQuery("select * from user");
//            while (rs.next()){
//                String user_id=rs.getString("user_id");
//                String user_account=rs.getString("user_account");
//                System.out.println(user_id+user_account);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        ApplicationContext context =
                new ClassPathXmlApplicationContext("main/java/test/Bean/Beans.xml");
        LogAndRegisterService lg =(LogAndRegisterService) context.getBean("LogAndRegisterService");
        lg.logIn("1","2");

    }
}
