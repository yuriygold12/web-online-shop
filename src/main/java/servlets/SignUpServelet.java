package servlets;
import beans.User;
import beans.UserState;
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
@WebServlet(name = "SignUpServlet", urlPatterns = {"/registration"})
public class SignUpServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String page;
        User user = colectUserInfo(req);
        user = saveToDb(user);
        if (user != null) {
            req.setAttribute("currentUser", user);
            page = "/user-page";
        } else {
            page = "failed-registration.html";
        }
        dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

    private User saveToDb(User user) {
        try {
            DaoFactory factory = new MySqlDaoFactory();
            DaoGenerick daoGenerick = factory.getDao(factory.getConnection(), User.class);
            user = (User) daoGenerick.create(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User colectUserInfo(HttpServletRequest req) {
        User user = null;
        String fn = req.getParameter("fn");
        String sn = req.getParameter("sn");
        String lg = req.getParameter("lg");
        String ps = req.getParameter("ps");
        String cps = req.getParameter("cps");
        String em = req.getParameter("em");
        if (ps.equals(cps)) {
            user = new User();
            user.setFirst_name(fn);
            user.setLast_name(sn);
            user.setLogin(lg);
            user.setPassword(ps);
            user.setEmail(em);
            user.setStatus(UserState.NEW);
        }
        return user;
    }
}
