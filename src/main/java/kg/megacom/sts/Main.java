package kg.megacom.sts;

import kg.megacom.sts.models.User;
import kg.megacom.sts.service.OrderService;
import kg.megacom.sts.service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        OrderService orderService = OrderService.INSTANCE;
        UserService userService = UserService.INSTANCE;
//        orderService.createTable();
//        userService.createTable();

        // Регистрация, авторизация
        System.out.println("Выберите операцию:\n" +
                "1 - Зарегестрироваться \n" +
                "2 - У вас уже есть аккаунт\n" +
                "3 - Я админ");
        switch (sc.nextInt()) {
            case 1: {
                System.out.println(user = userService.createUser());
            }
            break;
            case 2: {
                System.out.println(user = userService.userAuth());
            }
            break;
            case 3: {
                System.out.println("Выберите объект с которым хотите совершить операции.\n1 - Пользователь \n2 - Заявки");
                switch (sc.nextInt()) {
                    case 1: {
                        userService.operationWithUser();
                    }
                    break;
                    case 2: {
                        orderService.operationWithOrder();
                    }
                    break;
                }
            }
            return ;
        }

        // Создание запроса
        System.out.println();
        System.out.println("1) Отправить запрос         2) Посмотреть мои отправленные запросы");
        switch (sc.nextInt()) {
            case 1: {
                orderService.createOrder(user);
                break;
            }
            case 2: {
                System.out.println(orderService.getUserOrders(user));
                break;
            }
        }
    }
}
