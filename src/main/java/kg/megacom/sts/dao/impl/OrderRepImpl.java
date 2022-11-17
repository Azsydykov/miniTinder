package kg.megacom.sts.dao.impl;
import kg.megacom.sts.dao.DbHelperRep;
import kg.megacom.sts.dao.OrderRep;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.models.User;
import kg.megacom.sts.models.enums.Status;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepImpl implements OrderRep {
    DbHelperRep dbHelperRep = DbHelperRep.INSTANCE;
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
    public void createOrder(Order order) {
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("insert into tb_order (tb_user_id ,recipient_id,match,message,status) " +
                "VALUES (?, ?, ?, ?, ?)")) {

            ps.setLong(1, order.getUser().getId());
            ps.setLong(2, order.getUser().getId());
            ps.setBoolean(3, order.isMatch());
            ps.setString(4, order.getMessage());
            ps.setString(5, String.valueOf(order.getStatus()));

            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно добавлен");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при добавлении заявки");
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

                User user = new User();
                user.setId(resultSet.getLong("tb_user_id"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                order.setMessage(resultSet.getString("message"));
                order.setMatch(resultSet.getBoolean("match"));
                user.setId(resultSet.getLong("recipient_id"));
                order.setUser(user);
                orderList.add(order);
            }
            return orderList;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка заявок");
        }
    }
}
