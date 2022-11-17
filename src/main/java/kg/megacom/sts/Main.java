package kg.megacom.sts;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.models.User;
import kg.megacom.sts.models.enums.Status;
import kg.megacom.sts.service.OrderService;
import kg.megacom.sts.service.UserService;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = OrderService.INSTANCE;
        UserService userService = UserService.INSTANCE;
//        orderService.createTable();
//        userService.createTable();

        User user = new User();
        userService.createUser(user);
        List<User> userList = userService.getAllUsers();
        System.out.println();
        userList.stream().forEach(System.out::println);

        Order order = new Order();
        orderService.createOrder(order);


//        System.out.println("Зайти как админ - 0");
//        System.out.println("Зайти как пользователь - 1");
//
//        switch (sc.nextInt()) {
//            case 0:
//                crudOperationService.crudObjects();
//                break;
//            case 1:
//                crudOperationService.userCreating();
//                break;
//        }
        //  CrudOperationService crudOperationService = new CrudOperationServiceImpl();
    }
}
