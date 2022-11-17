package kg.megacom.sts.service.Impl;
import kg.megacom.sts.dao.OrderRep;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.service.OrderService;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRep orderRepImpl = OrderRep.INSTANCE;

    @Override
    public void createTable() throws SQLException {
        orderRepImpl.createTable();
    }

    @Override
    public Order createOrder(Order order)  {
            orderRepImpl.createOrder(order);
        return null;
    }
    @Override
    public List<Order> getAllOrders() {
        return orderRepImpl.getAllOrders();
    }
}
