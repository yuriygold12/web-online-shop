package dao.mysql;

import beans.Product;
import dao.core.AbstractDao;
import dao.core.DaoException;


import javax.naming.PartialResultException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDao<Product, String> {

    public ProductDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String getInsertQuery() {
        String insertProduct = "INSERT INTO `product` (`id`,`product_name`,`product_brand`,`product_price`,`product_model`,`product_color`) VALUES " +
                "(?,?,?,?,?,?)";
        return insertProduct;
    }

    @Override
    protected String getSelectQuery() {
        String selectQuery = "SELECT * FROM `product` WHERE id = ?";
        return selectQuery;
    }

    @Override
    protected String getDeleteQuery() {
        String deleteQuery = "DELETE FROM `product` WHERE id= ?";
        return deleteQuery;
    }

    @Override
    protected String getUpdateQuery() {
        String updateQury = "UPDATE `product` SET product_name=?, product_brand=? ,product_price=?, product_model=?,  product_color=?  WHERE `id`=?";
        return updateQury;
    }

    @Override
    protected String getSelectAll() {
        String selectAll = "SELECT * FROM `product`";
        return selectAll;
    }

    @Override
    protected void setInsertStatement(PreparedStatement preparedStatement, Product object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getId());
            preparedStatement.setString(2, object.getNameProduct());
            preparedStatement.setString(3, object.getBrandProduct());
            preparedStatement.setString(4, object.getPriceProduct());
            preparedStatement.setString(5, object.getProduct_model());
            preparedStatement.setString(6, object.getProduct_color());

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    protected void setStatementKey(PreparedStatement preparedStatement, String key) throws DaoException {
        try {
            preparedStatement.setString(1, key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setSelectStateament(PreparedStatement preparedStatement, Product object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getId());
        } catch (SQLException e) {
            throw new DaoException("isnt");
        }
    }

    @Override
    protected void setUpadateStatement(PreparedStatement preparedStatement, Product object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getNameProduct());
            preparedStatement.setString(2, object.getBrandProduct());
            preparedStatement.setString(3, object.getPriceProduct());
            preparedStatement.setString(4, object.getProduct_model());
            preparedStatement.setString(5, object.getProduct_color());
            preparedStatement.setString(6, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void setDeleteStatement(PreparedStatement preparedStatement, Product object) throws DaoException {
        try {
            preparedStatement.setString(1, object.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected List<Product> parseResultSet(ResultSet resultSet) throws DaoException {
        List<Product> products = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getString(1));
                product.setNameProduct(resultSet.getString(2));
                product.setBrandProduct(resultSet.getString(3));
                product.setPriceProduct(resultSet.getString(4));
                product.setProduct_model(resultSet.getString(5));
                product.setProduct_color(resultSet.getString(6));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
