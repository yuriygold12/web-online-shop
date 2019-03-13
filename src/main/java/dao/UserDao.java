package dao;

import beans.User;
import beans.UserState;
import dao.core.AbstractDao;
import dao.core.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao<User, String> {
    public UserDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getInsertQuery() {
        String insertQuery = "INSERT INTO `users` (`login`, `password`,`firstName`,`lastName`,`email` ,`status`) VALUES" +
                "(?, ?, ? ,?,? ,? )";
        return insertQuery;
    }

    @Override
    protected String getSelectQuery() {
        String selectLastRecord = "SELECT * FROM `users` WHERE login = ?";
        return selectLastRecord;
    }

    @Override
    protected String getDeleteQuery() {
        String qerySelect = "DELETE FROM `users` WHERE `login` = ?";
        return qerySelect;
    }

    @Override
    protected String getUpdateQuery() {
        String queryUpdate = "UPDATE `users` SET  password = ? , firstName=? ,LastName=? , email = ? ,status=?  WHERE  login  = ?";
        return queryUpdate;
    }

    @Override
    protected String getSelectAll() {
        String allQery = "SELECT * From `users`";
        return allQery;
    }

    @Override
    protected void setInsertStatement(PreparedStatement preparedStatement, User object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getLogin());
            preparedStatement.setString(2, object.getPassword());
            preparedStatement.setString(3, object.getFirst_name());
            preparedStatement.setString(4, object.getLast_name());
            preparedStatement.setString(5, object.getEmail());
            preparedStatement.setString(6, object.getStatus().toString());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected void setSelectStatement(PreparedStatement preparedStatement, User object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getLogin());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected void setStatementKey(PreparedStatement preparedStatement, String key) throws DaoException {
        try {
            preparedStatement.setString(1, key);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected void setDeleteStatement(PreparedStatement preparedStatement, User object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setUpdateStatement(PreparedStatement preparedStatement, User object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getPassword());
            preparedStatement.setString(2, object.getFirst_name());
            preparedStatement.setString(3, object.getLast_name());
            preparedStatement.setString(4, object.getEmail());
            preparedStatement.setString(5, object.getStatus().toString());
            preparedStatement.setString(6, object.getLogin());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<User> parseResultSet(ResultSet resultSet) throws DaoException {
        List<User> users = new ArrayList<>();
        try {
            while ((resultSet.next())) {
                User user = new User();
                user.setLogin(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setFirst_name(resultSet.getString(3));
                user.setLast_name(resultSet.getString(4));
                user.setEmail(resultSet.getString(5));
                user.setStatus(UserState.valueOf(resultSet.getString("status")));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return users;
    }
}
