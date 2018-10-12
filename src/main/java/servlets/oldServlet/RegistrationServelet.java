package servlets.oldServlet;

import beans.User;
import dao.core.DaoException;
import dao.core.DaoFactory;
import dao.core.DaoGenerick;
import dao.mysql.MySqlDaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Registration", urlPatterns = {"/reg"})
public class RegistrationServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        RequestDispatcher dispatcher;

        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("psw");
        String passwordRepeat = req.getParameter("psw-repeat");

        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        DaoFactory daoFactory = new MySqlDaoFactory();
        try {
            DaoGenerick daoGenerick = daoFactory.getDao(daoFactory.getConnection(), User.class);
            user = (User) daoGenerick.create(user);
        } catch (DaoException e) {
            printWriter.write("<h1> Problem with registration1 </h1>");
            dispatcher = req.getRequestDispatcher("registraction.html");
            dispatcher.include(req, resp);
            //dispatcher = req.getRequestDispatcher("failed-registration.html");
            //dispatcher.forward(req,resp);

        } catch (SQLException e) {
            printWriter.write("<h1>  Problem with registration3  </h1>");
            dispatcher = req.getRequestDispatcher("registraction.html");
            dispatcher.include(req, resp);
            //dispatcher = req.getRequestDispatcher("failed-registration.html");
            //dispatcher.forward(req,resp);
        }

        printWriter.write("<h1>  Connection Succeses  </h1>");
        dispatcher = req.getRequestDispatcher("success-registration.html.html");
        dispatcher.include(req, resp);

//        dispatcher = req.getRequestDispatcher("success-registration.html");
//        dispatcher.forward(req, resp);

//        printWriter.write("<!DOCTYPE html>\n" +
//                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <title>RegInfo</title>\n" +
//                "</head>\n" +
//                "<body>\n" +
//                "\n" +
//                "<h1>Login</h1>\n" +
//                "<h2>" + login + "</h2>\n" +
//                "<h1> Email </h1>\n" +
//                "<h2>" + email + "</h2>\n" +
//                "<h1> Password </h1>\n" +
//                "<h2>" + password + "</h2>\n" +
//                "<h1>PasswordRepeat</h1>\n" +
//                "<h2>" + passwordRepeat + "</h2>\n" +
//                "\n" +
//                "\n" +
//                "</body>\n" +
//                "</html>");
        printWriter.close();
    }
}




