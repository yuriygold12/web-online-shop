package servlets;

import beans.User;
import beans.UserState;
import dao.core.DaoException;
import dao.core.DaoFactory;
import dao.core.DaoGenerick;
import dao.mysqlDaoFactory.MySqlDaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/update-user-data"})
public class UpdateUserData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/user-page");
        User user = getOptions(req);
        if (updateUserInDB(user)) {
            req.setAttribute("currentUser", user);
        }
        dispatcher.forward(req, resp);
    }

    private boolean updateUserInDB(User user) {
        try {
            DaoFactory factory = new MySqlDaoFactory();
            DaoGenerick daoGenerick = factory.getDao(factory.getConnection(), User.class);
            daoGenerick.update(user);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private User getOptions(HttpServletRequest req) {
        String password = req.getParameter("ps");
        String firstName = req.getParameter("fn");
        String lastName = req.getParameter("ln");
        String email = req.getParameter("em");
        String status = req.getParameter("st");
        String login = req.getParameter("lg");
        User user = new User();
        user.setLast_name(lastName);
        user.setFirst_name(firstName);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(UserState.valueOf(status));
        return user;
    }
}
