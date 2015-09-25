package service;

/*the brain of my app, which is creating a user
* TODO: connect this w/ Servlet */
import DAO.RegisterDAO;
import model.User;

import java.sql.SQLException;

public class RegistrationService {
    RegisterDAO registerDAO = new RegisterDAO();
    User user = new User();

   public  void createUser(){
       //proveryaet connection s DAo i vyzyvaet DAO
       if (registerDAO.getConn() == null) {
           registerDAO.createConnection();
       }
       try {
           registerDAO.createUser(user);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
public boolean ifUserExists(User user) {
        if (user.getEmail() == null)

    return false;
    return false;
}
    //v DAO realizovali soedineniye s DB, nado ego zapustit'
    public void addUser(User user) throws SQLException {
        registerDAO.createUser(user);
    }
}
