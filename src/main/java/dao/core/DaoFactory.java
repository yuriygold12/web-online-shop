package dao.core;

import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {
    Connection getConnection() throws SQLException;

    DaoGenerick getDao(Connection connection, Class daoClass) throws DaoException;
}
