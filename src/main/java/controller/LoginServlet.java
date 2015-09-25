package controller;

//import service.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(
        name = "LoginPage",
        description = "A login page",
        urlPatterns = {"/login"})
@Path("/login/")
public class LoginServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
//don't know what to do
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException{
            String username = req.getParameter("uname");
            String password = req.getParameter("pass");

            res.setContentType("text/html");
        }

    }



