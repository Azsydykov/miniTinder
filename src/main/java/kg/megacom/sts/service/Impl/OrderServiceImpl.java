package kg.megacom.sts.service.Impl;
import kg.megacom.sts.dao.OrderRep;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.service.OrderService;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRep orderRep = OrderRep.INSTANCE;

    @Override
    public void createTable() throws SQLException {
        orderRep.createTable();
    }

    @Override
    public Order createOrder(Order order)  {
            orderRep.createOrder(order);
        return null;
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRep.getAllOrders();
    }
}
