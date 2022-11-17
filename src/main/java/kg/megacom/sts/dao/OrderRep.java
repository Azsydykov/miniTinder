package kg.megacom.sts.dao;

import kg.megacom.sts.dao.impl.OrderRepImpl;
import kg.megacom.sts.models.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRep {
    OrderRep INSTANCE = new OrderRepImpl();
    void createTable() throws SQLException;
    void createOrder(Order order);
    public List<Order> getAllOrders();
}
