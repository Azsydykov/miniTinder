package kg.megacom.sts.service;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.service.Impl.OrderServiceImpl;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    OrderService INSTANCE = new OrderServiceImpl();

    void createTable() throws SQLException;
    Order createOrder(Order order);
    public List<Order> getAllOrders();
}
