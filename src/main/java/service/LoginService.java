package service;
import DAO.LoginDAO;
import model.User;

import java.sql.SQLException;
public class LoginService {
    LoginDAO loginDAO = new LoginDAO();
    User user = new User();
    public User ifUserExists(User user) {
        return user;
    }

}
