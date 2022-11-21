package kg.megacom.sts.service.Impl;

import kg.megacom.sts.dao.OrderRep;
import kg.megacom.sts.models.Order;
import kg.megacom.sts.models.User;
import kg.megacom.sts.models.enums.OrderStatus;
import kg.megacom.sts.service.OrderService;
import kg.megacom.sts.service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    OrderRep orderRep = OrderRep.INSTANCE;
    UserService userService = UserService.INSTANCE;
    Scanner sc = new Scanner(System.in);

    @Override
    public void createTable() throws SQLException {
        orderRep.createTable();
    }

    private List<User> checkIfOrderExists(List<User> userList, User user) {

        List<Order> userOrdersList = orderRep.getUserOrders(user);
        List<User> uList = new ArrayList<>();
        for (User u : userList) {
            userOrdersList.forEach(x -> {
                if (x.getRecipient().getId() != u.getId());
            });

        }
        return uList;
    }

    @Override
    public Order createOrder(User user) {
        Order orderNew = new Order();
        int scannedNum;
        System.out.println("Вывберите пользователя из списка!");
        System.out.println();
        AtomicInteger counter = new AtomicInteger(1);
        List<User> userList = userService.getAllUsers();
        List<User> selectedUserList = userList.stream().filter(x -> x.getId() != user.getId()).collect(Collectors.toList());

        selectedUserList.forEach(x -> {
            System.out.print(counter.get());
            System.out.println(": Имя - " + x.getName());
            System.out.println("Описание - " + x.getDefinition());
            System.out.println("Возраст - " + x.getAge());
            System.out.println();
            counter.getAndIncrement();
        });

        scannedNum = sc.nextInt();
        User selectedUser = selectedUserList.get(scannedNum - 1);
        System.out.println("Вы выбрали " + selectedUser.getName());
        orderNew.setRecipientId(selectedUser);
        System.out.println("Выше тайное сообщение:");
        orderNew.setMessage(sc.next());
        if (orderRep.check(selectedUser.getId(), user.getId())) {
            orderNew.setMatch(true);
            orderNew.setStatus(OrderStatus.ВЗАИМНО);
            orderRep.updateOrder(orderRep.getOrderIdByUsers(selectedUser.getId(), user.getId()));
            System.out.println(ANSI_GREEN + "У вас взаимная симпатия!"+ ANSI_RESET);
        } else {
            orderNew.setMatch(false);
            orderNew.setStatus(OrderStatus.ЗАПРОС_ОТПРАВЛЕН);

        }
        orderNew.setUser(user);
        saveOrder(orderNew);
        System.out.println("Запрос успешно создан!");
        return orderNew;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRep.getAllOrders();
    }

    @Override
    public void operationWithOrder() {
        System.out.println("Выберите операцию:\n" +
                "1 - Получить список заявок \n" +
                "2 - Удалить заявку по id(пока не работает)\n" +
                "3 - Вывести заявку по id(пока не работает)");

        int chooseOperation = sc.nextInt();
        switch (chooseOperation) {

            case 1:
                System.out.println("\n Список заявок");
                System.out.println(orderRep.getAllOrders());
                break;
            case 2:
                System.out.println(orderRep.getAllOrders());
                System.out.println("\nВведите id заявки, которую хотите удалить: ");
                orderRep.deleteOrderById(sc.nextInt());
                break;
            case 3:
                System.out.println("Введите id заявки, которую хотите вывести:");
                System.out.println(orderRep.getOrderById(sc.nextLong()));
                break;
        }
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRep.getOrderById(id);
    }

    @Override
    public void deleteOrderById(int id) {
        orderRep.deleteOrderById(id);

    }

    @Override
    public void saveOrder(Order order) {
        orderRep.saveOrder(order);
    }

    @Override
    public boolean check(Long userId, Long recipient) {
        return orderRep.check(userId, recipient);
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderRep.getUserOrders(user);
    }

    @Override
    public void updateOrder(long id) {
        orderRep.updateOrder(id);
    }

    @Override
    public long getOrderIdByUsers(long userId, long recipientId) {
        return orderRep.getOrderIdByUsers(userId, recipientId);
    }
}
