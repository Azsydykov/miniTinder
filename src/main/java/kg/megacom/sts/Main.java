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
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        OrderService orderService = OrderService.INSTANCE;
        UserService userService = UserService.INSTANCE;
//        orderService.createTable();
//        userService.createTable();

        System.out.println("0 - Зайти как админ \n1 - Зайти как пользователь");
        switch (sc.nextInt()) {
            case 0:
                System.out.println("Выберите объект с которым хотите совершить операции.\n0 - Пользователь \n1 - Заявки");
                int answer = sc.nextInt();
                if (answer == 0) {
                    System.out.println("Выберите операцию:\n" +
                            "1 - Получить список пользователей \n" + "2 - Удалить пользователя по id \n" +
                            "3 - Вывести пользователя по id \n");
                    int chooseOperation = sc.nextInt();
                    switch (chooseOperation) {
                        case 1:
                            System.out.println("\n Список пользователей");
                            System.out.println(userService.getAllUsers());
                            break;
                        case 2:
                            System.out.println(userService.getAllUsers());
                            System.out.println("\nВведите id пользователя, которого хотите удалить: ");
                            userService.deleteUser(sc.nextInt());
                            break;
                        case 3:
                            System.out.println("Введите id пользователя для вывода");
                            System.out.println(userService.getUserById(sc.nextLong()));
                            break;
                    }
                }
                if (answer == 1) {
                    System.out.println("Выберите операцию:\n" +
                            "1 - Получить список заявок \n" +
                            "2 - Удалить заявку по id\n" +
                            "3 - Вывести заявку по id");

                    int chooseOperation = sc.nextInt();
                    switch (chooseOperation) {

                        case 1:
                            System.out.println("\n Список заявок");
                            System.out.println(orderService.getAllOrders());
                            break;
                        case 2:
                            System.out.println(orderService.getAllOrders());
                            System.out.println("\nВведите id заявки, которую хотите удалить: ");
                            // userService.deleteUser(sc.nextInt());
                            break;
                        case 3:
                            System.out.println("Введите id заявки для вывода");
                            //  System.out.println(userService.getUserById(sc.nextLong()));
                            break;
                    }
                }

            case 1:
                boolean result = false;
                while (result != true) {
                    System.out.println("\n0 - Создать аккаунт \n1 - У вас уже есть аккаунт");
                    int answer1 = sc.nextInt();
                    if (answer1 == 0) {
                        System.out.println("Введите имя пользователя: ");
                        String userName = sc.next();
                        System.out.println("Введите возраст: ");
                        int age = sc.nextInt();
                        User user = new User();
                        System.out.println("Напишите что-нибудь о себе: ");
                        String definition = sc.nextLine();
                        definition = sc.nextLine();
                        user.setName(userName);
                        user.setAge(age);
                        user.setDefinition(definition);
                        user.setStatus(Status.NEW);
                        System.out.println("Ваш email адресс: ");
                        String email = sc.next();
                        user.setEmail(email);
                        userService.createUser(user);
                        System.out.println("Вы успешно создали пользователя с именем " + userName);
                        result = false;
                    if (answer1==1){
                        System.out.println("Введите ваш email адрес: ");

                    }
                    }


//
//                    System.out.println("Выберите операцию:\n" +
//                            "1 - Получить список пользователей \n" + "2 - Удалить пользователя по id \n" +
//                            "3 - Вывести пользователя по id \n");
//                    int chooseOperation = sc.nextInt();
//                    switch (chooseOperation) {
//                        case 1:
//                            System.out.println("\n Список пользователей");
//                            System.out.println(userService.getAllUsers());
//                            break;
//                        case 2:
//                            System.out.println(userService.getAllUsers());
//                            System.out.println("\nВведите id пользователя, которого хотите удалить: ");
//                            userService.deleteUser(sc.nextInt());
//                            break;
//                        case 3:
//                            System.out.println("Введите id пользователя для вывода");
//                            System.out.println(userService.getUserById(sc.nextLong()));
//                            break;
//                    }
//                }
//                if (answer == 1) {
//                    System.out.println("Выберите операцию:\n" +
//                            "1 - Получить список заявок \n" +
//                            "2 - Удалить заявку по id\n" +
//                            "3 - Вывести заявку по id");
//
//                    int chooseOperation = sc.nextInt();
//                    switch (chooseOperation) {
//
//                        case 1:
//                            System.out.println("\n Список заявок");
//                            System.out.println(orderService.getAllOrders());
//                            break;
//                        case 2:
//                            System.out.println(orderService.getAllOrders());
//                            System.out.println("\nВведите id заявки, которую хотите удалить: ");
//                            // userService.deleteUser(sc.nextInt());
//                            break;
//                        case 3:
//                            System.out.println("Введите id заявки для вывода");
//                            //  System.out.println(userService.getUserById(sc.nextLong()));
//                            break;
//                    }
//
//
//
//
//

//                        case 1:
//                            System.out.println(userService.getAllUsers());
//                            System.out.println("Введите id пользователя: ");
//                            Long userId = sc.nextLong();
//
//
//                            Order order = new Order();
//
//                            System.out.println("Message: ");
//                            String message = sc.next();
//                            System.out.println("match: ");
//                            boolean match = sc.nextBoolean();
//
//                            System.out.println("RecipientId: ");
//                            long recipientId = sc.nextLong();
//
//                            order.setId(userId);
//                            order.setMessage(message);
//                            order.setMatch(match);
//                            order.setRecipientId(recipientId);
//                            orderService.sendingOrder(order);
//                            System.out.println("Вы успешно создали заявку");
//                            break;


                }
        }
    }
}