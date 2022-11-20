package kg.megacom.sts.dao.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import kg.megacom.sts.dao.DbHelperRep;
import kg.megacom.sts.dao.OrderRep;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.models.User;
import kg.megacom.sts.models.enums.OrderStatus;
import kg.megacom.sts.models.enums.UserStatus;
import kg.megacom.sts.service.Impl.UserServiceImpl;
import kg.megacom.sts.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderRepImpl implements OrderRep {
    DbHelperRep dbHelperRep = DbHelperRep.INSTANCE;
    UserService userService = new UserServiceImpl();

    @Override
    public void createTable() throws SQLException {
        String sqlCreate = " CREATE TABLE IF NOT EXISTS " + "tb_order"
                + " ( id                INTEGER, "
                + "   tb_user_id        INTEGER,"
                + "   recipient_id      INTEGER, "
                + "   match             VARCHAR(100)  ,"
                + "   message           VARCHAR(100) , "
                + "   status            VARCHAR(50)  )";

        try (Statement stmt = dbHelperRep.connect().createStatement()) {
            stmt.execute(sqlCreate);
        }
    }

    @Override
    public void saveOrder(Order order) {
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("insert into tb_order (tb_user_id ,recipient_id,match,message,status) " +
                "VALUES (?, ?, ?, ?, ?)")) {

            ps.setLong(1, order.getUser().getId());
            ps.setLong(2, order.getRecipient().getId());
            ps.setBoolean(3, order.isMatch());
            ps.setString(4, order.getMessage());
            ps.setString(5, String.valueOf(order.getStatus()));

            ps.execute();

        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();

        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("SELECT * FROM tb_order")) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getLong("id"));

                order.setUser(userService.getUserById(resultSet.getLong("tb_user_id")));
                order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));
                order.setRecipientId(userService.getUserById(resultSet.getLong("recipient_id")));

                orderList.add(order);
            }
            return orderList;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка заявок");
        }
    }

    @Override
    public Order getOrderById(Long id) {
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("select * from tb_order where id= ?")) {
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();

            Order order = new Order();
            while (resultSet.next()) {
                order.setId(resultSet.getLong("id"));
                User user = new User();
                user.setId(resultSet.getLong("tb_user_id"));
                order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));
                user.setId(resultSet.getLong("recipient_id"));
                order.setUser(user);
            }
            return order;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе пользователя!");
        }
    }

    @Override
    public void deleteOrderById(int id) {
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("delete from tb_order where id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Заявка успешно удалена.");

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении заявки!");
        }

    }

    @Override
    public boolean check(Long userId, Long recipient) {
        try (PreparedStatement ps = dbHelperRep.connect()
                .prepareStatement("select * from tb_order o where o.tb_user_id=? AND o.recipient_id=?")) {
            ps.setLong(1, userId);
            ps.setLong(2, recipient);
            ResultSet resultSet = ps.executeQuery();

            return resultSet.next();
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при проверке заявок!");
        }
    }

    @Override
    public List<Order> getUserOrders(User user) {
        List<Order> userOrdersList = new ArrayList<>();

        try (PreparedStatement ps = dbHelperRep.connect()
                .prepareStatement("select * from tb_order o where o.tb_user_id=?")) {
            ps.setLong(1, user.getId());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
                order.setMessage(resultSet.getString("message"));
                order.setUser(user);
                order.setRecipientId(userService.getUserById(resultSet.getLong("recipient_id")));

                userOrdersList.add(order);
            }
            return userOrdersList;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка заявок");
        }
    }

    @Override
    public void updateOrder(long id) {

        String status = String.valueOf(OrderStatus.ВЗАИМНО);
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("Update tb_order set status=?, match=true where id=?")) {

            ps.setString(1, status);
            ps.setLong(2, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при изменении запроса!");
        }
    }

    @Override
    public long getOrderIdByUsers(long userId, long recipientId) {
        try (PreparedStatement ps = dbHelperRep.connect()
                .prepareStatement("SELECT id from tb_order WHERE tb_user_id = ? and recipient_id = ?")) {
            ps.setInt(1, Math.toIntExact(userId));
            ps.setInt(2, Math.toIntExact(recipientId));
            ResultSet resultSet = ps.executeQuery();
            long orderId = 0;

            while (resultSet.next()) {
                orderId = (resultSet.getLong("id"));
            }
            return orderId;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе пользователя!");
        }
    }
}
