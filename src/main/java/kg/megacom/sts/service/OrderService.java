package kg.megacom.sts.service;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.models.User;
import kg.megacom.sts.service.Impl.OrderServiceImpl;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    OrderService INSTANCE = new OrderServiceImpl();

    void createTable() throws SQLException;
    Order createOrder(User user);
    public List<Order> getAllOrders();
    Order getOrderById(Long id);
    public void deleteOrderById(int id);
    void operationWithOrder();
    void saveOrder(Order order);
}
