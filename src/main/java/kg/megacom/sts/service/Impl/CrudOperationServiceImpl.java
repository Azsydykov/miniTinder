//package kg.megacom.sts.service.Impl;
//import kg.megacom.sts.models.Order;
//import kg.megacom.sts.models.enums.Status;
//import kg.megacom.sts.models.User;
//import kg.megacom.sts.service.CrudOperationService;
//import kg.megacom.sts.service.OrderService;
//import kg.megacom.sts.service.UserService;
//import java.util.Scanner;
//
//public class CrudOperationServiceImpl implements CrudOperationService {
//
//    Scanner sc = new Scanner(System.in);
//    UserService userService = new UserServiceImpl();
//    OrderService orderService = new OrderServiceImpl();
//
//
//    @Override
//    public void crudObjects() {
//
//        System.out.println("Выберите объект с которым хотите совершить операции.\n1-пользователь, 2-заявки");
//        int answer = sc.nextInt();
//        if (answer == 1) {
//            System.out.println("Выберите операцию.\n" +
//                    "Получить список пользователей - 1 \n" + "Удалить пользователя по id- 2 \n" +
//                    "Вывести пользователя по id - 3 \n" +
//                    "Изменить пользователя - 4 \n");
//            int chooseOperation = sc.nextInt();
//            switch (chooseOperation) {
//                case 1:
//                    System.out.println("\n Список пользователей");
//                    System.out.println(userService.getAllUsers());
//                    break;
//                case 2:
//                    System.out.println(userService.getAllUsers());
//                    System.out.println("\nВведите id пользователя, которого хотите удалить: ");
//                    userService.deleteUser(sc.nextInt());
//                    break;
//                case 3:
//                    System.out.println("Введите id пользователя для вывода");
//                    System.out.println(userService.getUserById(sc.nextLong()));
//                    break;
//                case 4:
//
//                    break;
//            }
//        }
//        if (answer == 2) {
//            System.out.println("Выберите операцию.\n" +
//                    "Создать заявку - 1 \n" + "Получить список заявок - 2 \n" +
//                    "Изменить заявку - 3 \n" +
//                    "Удалить заявку по id - 4 \n" +
//                    "Вывести заявку по id - 5");
//            int chooseOperation = sc.nextInt();
//            switch (chooseOperation) {
//                case 1:
//                    System.out.println(userService.getAllUsers());
//                    System.out.println("Введите id пользователя: ");
//                    Long userId = sc.nextLong();
//
//
//                    Order order = new Order();
//
//                    System.out.println("Message: ");
//                    String message = sc.next();
//                    System.out.println("match: ");
//                    boolean match = sc.nextBoolean();
//
//                    System.out.println("RecipientId: ");
//                    long recipientId = sc.nextLong();
//
//                    order.setId(userId);
//                    order.setMessage(message);
//                    order.setMatch(match);
//                    order.setRecipientId(recipientId);
//                    orderService.sendingOrder(order);
//                    System.out.println("Вы успешно создали заявку");
//                    break;
//                case 2:
//                    System.out.println("\n Список заявок");
//                    System.out.println(orderService.getAllOrders());
//                    break;
//                case 3:
//
//                    break;
//                case 4:
//                    System.out.println(orderService.getAllOrders());
//                    System.out.println("\nВведите id заявки, которую хотите удалить: ");
//                   // userService.deleteUser(sc.nextInt());
//                    break;
//                case 5:
//                    System.out.println("Введите id заявки для вывода");
//                  //  System.out.println(userService.getUserById(sc.nextLong()));
//                    break;
//            }
//        }
//    }
//
//    @Override
//    public void gettStatus() {
//        int count = 1;
//        for (Status item : Status.values()) {
//            System.out.println(count + "- " + item);
//            count++;
//        }
//    }
//
//    @Override
//    public void userCreating() {
//
//        System.out.println("Создать аккаунт - 1");
//        System.out.println("У вас уже есть аккаунт - 2");
//        int chooseOperation = sc.nextInt();
//        switch (chooseOperation) {
//            case 1:
//                System.out.println("Введите имя пользователя: ");
//                String userName = sc.next();
//                System.out.println("Введите возраст: ");
//                int age = sc.nextInt();
//                User user = new User();
//                System.out.println("Напишите что-нибудь о себе: ");
//                String def = sc.nextLine();
//                def = sc.nextLine();
//                user.setName(userName);
//                user.setAge(age);
//                user.setDefinition(def);
//                System.out.println("Ваш email адресс: ");
//                String email = sc.next();
//
//
//                user.setEmail(email);
//                userService.createUser(user);
//                System.out.println("Вы успешно создали пользователя с именем " + userName);
//                break;
//            case 2:
//                System.out.println("\n еще не готово!");
//
//                break;
//
//
//        }
//    }
//}