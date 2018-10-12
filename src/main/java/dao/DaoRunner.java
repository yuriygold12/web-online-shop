package dao;

import beans.Product;
import beans.User;
import beans.UserState;
import dao.core.DaoException;
import dao.core.DaoFactory;
import dao.core.DaoGenerick;
import dao.mysql.MySqlDaoFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DaoRunner {
    private static final Logger log = Logger.getLogger(DaoRunner.class);

    public static void main(String[] args) {
//        try {


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//User
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//            DaoFactory factory = new MySqlDaoFactory();
//            DaoGenerick daoGenerick = factory.getDao(factory.getConnection(), User.class);
//            User user = new User();
//            user.setLogin("Na1");
//            user.setPassword("yy22113y");
//            user.setFirst_name("yur3a");
//            user.setLast_name("bahlay2");
//            user.setEmail("5555@g12311");
//            user.setStatus(UserState.NEW);
//            user = (User) daoGenerick.create(user);
//            System.out.println(user);
//
//
//            DaoGenerick daoGenerick1 = factory.getDao(factory.getConnection(), User.class);
//            User user1 = (User) daoGenerick1.read("Na");
//            System.out.println(user1);
//
//
//            DaoGenerick daoGenerick2 = factory.getDao(factory.getConnection(), User.class);
//            User user2 = new User();
//            user2.setLogin("Na");
//            user2.setPassword("");
//            user2.setEmail("5555");
//            user2.setStatus(UserState.NEW);
//            daoGenerick2.delete(user2);
//
//
//            DaoGenerick DaoGenerick3 = factory.getDao(factory.getConnection(), User.class);
//            User user6 = new User();
//
//            user6.setPassword("11111");
//            user6.setFirst_name("fdfdf");
//            user6.setLast_name("fsfsdf");
//            user6.setEmail("11111");
//            user6.setStatus(UserState.ACTIVE);
//            user6.setLogin("Na1");
//            DaoGenerick3.update(user6);
//
//
//            DaoGenerick daoGenerick4 = factory.getDao(factory.getConnection(), User.class);
//            List<User> users = daoGenerick4.getAll();
//            for (User item : users) {
//                System.out.println(item);
//            }


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Product
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//            DaoFactory factory = new MySqlDaoFactory();
//            DaoGenerick daoGenerick7 = factory.getDao(factory.getConnection(), Product.class);
//            Product product = new Product();
//            product.setId("4");
//            product.setNameProduct("Hpacer");
//            product.setBrandProduct("probook 4g0");
//            product.setPriceProduct("6900");
//            product.setDate(LocalDate.now());
//            product.setEnd_datasecond(LocalDate.of(2019, 5, 15));
//            product.setEnd_date(LocalDate.of(2020, 7, 12));
//            product = (Product) daoGenerick7.create(product);
//            System.out.println(product.toString());


//            DaoGenerick daoGenerick9 = factory.getDao(factory.getConnection(), Product.class);
//            Product product2 = (Product) daoGenerick9.read("4");
//            System.out.println(product2);


//            Product product3 = new Product();
//            product3.setNameProduct("Samsung");
//            product3.setBrandProduct("lite");
//            product3.setPriceProduct("10900");
//            product3.setDate(LocalDate.of(2013, 6, 23));
//            product3.setEnd_datasecond(LocalDate.of(2019, 5, 11));
//            product3.setEnd_date(LocalDate.of(2020, 7, 12));
//            product3.setId("2");
//            DaoGenerick daoGenerick10 = factory.getDao(factory.getConnection(), Product.class);
//            daoGenerick10.update(product3);


//            Product product3 = new Product();
//            product3.setId("3");
//            DaoGenerick daoGenerick8 = factory.getDao(factory.getConnection(), Product.class);
//            daoGenerick8.delete(product3);

//        } catch (DaoException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
