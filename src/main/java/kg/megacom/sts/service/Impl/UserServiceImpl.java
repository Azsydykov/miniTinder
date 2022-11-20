package kg.megacom.sts.service.Impl;

import kg.megacom.sts.dao.UserRep;
import kg.megacom.sts.models.User;
import kg.megacom.sts.models.enums.UserStatus;
import kg.megacom.sts.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    Scanner sc = new Scanner(System.in);
    UserRep userRep = UserRep.INSTANCE;



    @Override
    public void createTable() throws SQLException {
        userRep.createTable();
    }

    @Override
    public User createUser() {
        User newUser = new User();
        System.out.println("Пройдите регистрацию");
        System.out.println("Введите ваше имя:");
        newUser.setName(sc.next());
        System.out.println("Сколько вам лет:");
        newUser.setAge(sc.nextInt());
        System.out.println("Напишите о себе:");
        newUser.setDefinition(sc.next());
        System.out.println("Ваш email:");
        newUser.setEmail(sc.next());
        newUser.setStatus(UserStatus.NEW);

        System.out.println();
        System.out.println("Пользователь успешно создан");

        try {
            userRep.save(newUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return findByEmail(newUser.getEmail());
    }

    @Override
    public List<User> getAllUsers() {
        return userRep.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userRep.getUserById(id);
    }

    @Override
    public void deleteUser(int id) {
        userRep.deleteUser(id);
    }

    @Override
    public boolean changeStatus(User user, int userStatusCode) {
        return false;
    }

    @Override
    public User userAuth() {
        System.out.println("Введите ваш email адрес:");
        String userLogin = sc.next();
        User foundUser = findByEmail(userLogin);
        while (foundUser.getEmail() == null) {
            System.out.println("Пользователь не найден повторите еще!");
            userAuth();
        }
        return foundUser;
    }

    @Override
    public User findByEmail(String email) {
        try {
            User user = userRep.findByEmail(email);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void operationWithUser() {

            System.out.println("Выберите операцию:\n" +
                    "1 - Получить список пользователей \n" + "2 - Удалить пользователя по id \n" +
                    "3 - Вывести пользователя по id \n");
            int chooseOperation = sc.nextInt();
            switch (chooseOperation) {
                case 1:
                    System.out.println("\n Список пользователей");
                    System.out.println(userRep.getAllUsers());
                    break;
                case 2:
                    System.out.println(userRep.getAllUsers());
                    System.out.println("\nВведите id пользователя, которого хотите удалить: ");
                    userRep.deleteUser(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Введите id пользователя для вывода");
                    System.out.println(userRep.getUserById(sc.nextLong()));
                    break;
            }
        }
    }

