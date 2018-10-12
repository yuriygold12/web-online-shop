package dao.core;

import beans.User;

import java.util.List;

public interface DaoGenerick<T, V> {
    T create(T object) throws DaoException;

    T read(V key) throws DaoException;

    User update(T object) throws DaoException;

    void delete(T object) throws DaoException;

    List<T> getAll() throws DaoException;
}
