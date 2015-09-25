package DAO;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import model.User;

import java.beans.Statement;
import java.sql.*;

//we need URL of DAO
public class RegisterDAO {
    String dbURL = "jdbc:mysql://localhost:3306/Users";
    String username = "root";
    String password = "welcome";
    Connection conn = null;

    public void createConnection() {
        try {
            Connection conn = DriverManager.getConnection(dbURL, username, password);

            if (conn != null) {
                System.out.println("Connected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO Users (username, password, email) VALUES (?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            //AUTO_INCREMENT id
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail(User user) throws SQLException {
        String sql = "SELECT * FROM Users U WHERE U.email = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getEmail());
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
