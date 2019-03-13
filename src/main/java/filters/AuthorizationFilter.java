package filters;

import beans.User;
import dao.core.DaoException;
import dao.core.DaoFactory;
import dao.core.DaoGenerick;
import dao.mysqlDaoFactory.MySqlDaoFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AuthorizationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = getUserFromDb(request);
        if (user != null) {
            request.setAttribute("currentUser", user);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect("wrongData.html");
        }
    }

    private User getUserFromDb(HttpServletRequest req) {
        String login = req.getParameter("lg");
        String password = req.getParameter("ps");
        User user = null;
        try {
            DaoFactory factory = new MySqlDaoFactory();
            DaoGenerick daoGenerick = factory.getDao(factory.getConnection(), User.class);
            user = (User) daoGenerick.read(login);
            System.out.println();
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

    @Override
    public void destroy() {
    }
}
