package servlets;

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
import java.sql.SQLException;

@WebServlet(name = "SignInServlet", urlPatterns = {"/sign-in"})
public class SignInServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String page;
        User user = getUserFromDb(req);
        if (user != null) {
            req.setAttribute("currentUser", user);
            page = "/user-page";
        } else {
            page = "failed-registration.html";
        }
        dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    private User getUserFromDb(HttpServletRequest req) {
        String login = req.getParameter("lg");
        String password = req.getParameter("ps");
        User user = null;
        try {
            DaoFactory factory = new MySqlDaoFactory();
            DaoGenerick daoGenerick = factory.getDao(factory.getConnection(), User.class);
            user = (User) daoGenerick.read(login);
            if (user.getPassword().equals(password)) {
                return user;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
