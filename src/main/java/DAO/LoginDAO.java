package DAO;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import model.User;

import java.beans.Statement;
import java.sql.*;

//we need URL of DAO
public class LoginDAO {
    String dbURL = "jdbc:mysql://localhost:3306/Users";
    String username = "root";
    String password = "welcome";
    Connection conn = null;
    User user = new User();
    public void createConnection(){
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null){
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConn() {
        return conn;
    }

    public User getUser(User user)throws SQLException {
        String sql = "SELECT * FROM Users U WHERE U.username = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getUserName());
        ResultSet resultSet = statement.executeQuery();
        User userResult = new User();
        //na4alo mappinga na object (from my sql table)
        userResult.setUserId(Integer.getInteger(resultSet.getString("Id")));
        userResult.setUserName(resultSet.getString("username"));
        userResult.setPassword(resultSet.getString("password"));
        userResult.setEmail(resultSet.getString("email"));
        //end of mapping

        return userResult;
    }
}
