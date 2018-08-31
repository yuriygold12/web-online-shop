package dao;

import java.sql.Connection;

public interface DaoCreater {
    DaoGenerick create(Connection connection);
}
