package kg.megacom.sts.service.Impl;
import kg.megacom.sts.models.Status;
import kg.megacom.sts.models.User;
import kg.megacom.sts.service.CrudOperationService;
import kg.megacom.sts.service.UserService;
import java.util.Scanner;

public class CrudOperationServiceImpl implements CrudOperationService {

    Scanner sc = new Scanner(System.in);
    UserService userService = new UserServiceImpl();


    @Override
    public void crudObjects() {

        System.out.println("Выберите объект с которым хотите совершить операции.\n1-пользователь, 2-order");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Выберите операцию.\n" +
                    "Создать пользователя - 1 \n" + "Получить список пользователей - 2 \n" +
                    "Изменить пользователя - 3 \n" +
                    "Удалить пользователя по id - 4 \n" +
                    "Вывести пользователя по id - 5");
            int chooseOperation = sc.nextInt();
            switch (chooseOperation) {
                case 1:
                    System.out.println("Введите имя пользователя: ");
                    String userName = sc.next();
                    System.out.println("Введите возраст: ");
                    int age = sc.nextInt();
                    System.out.println("Напишите что-нибудь о себе: ");
                    String diff = sc.next();

                    System.out.println("Ваш email адресс: ");
                    String email = sc.next();
                    System.out.println("Введите номер телефона: ");
                    String phoneNumber = sc.next();
                    System.out.println("Выберите Ваш статус: ");
                    gettStatus();

                    User user = new User();

                    int chooseStatus = sc.nextInt();
                    switch (chooseStatus) {
                        case 1:
                            user.setStatus(Status.ВЗАИМНО);
                            break;
                        case 2:
                            user.setStatus(Status.В_ОЖИДАНИИ);
                            break;
                        case 3:
                            user.setStatus(Status.НЕ_ВЗАИМНО);
                            break;
                    }

                    user.setName(userName);
                    user.setAge(age);
                    user.setDiff(diff);
                    user.setEmail(email);
                    user.setNumber(phoneNumber);
                    userService.createUser(user);
                    System.out.println("Вы успешно создали пользователя с именем " + userName);
                    break;
                case 2:
                    System.out.println("\n Список пользователей");
                    System.out.println(userService.getAllUsers());
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println(userService.getAllUsers());
                    System.out.println("\nВведите id пользователя, которого хотите удалить: ");
                    userService.deleteUser(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Введите id пользователя для вывода");
                    System.out.println(userService.getUserById(sc.nextLong()));
                    break;
            }
        }if (answer == 2) {
            System.out.println("Выберите операцию.\n" +
                    "Создать order - 1 \n" + "Получить список order - 2 \n" +
                    "Изменить order - 3 \n" +
                    "Удалить orde по id - 4 \n" +
                    "Вывести order по id - 5");
    }
    }

    @Override
    public void gettStatus() {
        int count = 1;
        for (Status item : Status.values()) {
            System.out.println(count + "- " + item);
            count++;
        }
    }

    @Override
    public void userCreating() {

            System.out.println("Создать аккаунт - 1");
            System.out.println("У вас уже есть аккаунт - 2");
            int chooseOperation = sc.nextInt();
            switch (chooseOperation) {
                case 1:
                    System.out.println("Введите имя пользователя: ");
                    String userName = sc.next();
                    System.out.println("Введите возраст: ");
                    int age = sc.nextInt();
                    User user = new User();
                    System.out.println("Напишите что-нибудь о себе: ");
                    String diff = sc.next();
                    user.setName(userName);
                    user.setAge(age);
                    user.setDiff(diff);
                    System.out.println("Ваш email адресс: ");
                    String email = sc.next();
                    System.out.println("Введите номер телефона: ");
                    String phoneNumber = sc.next();
                    System.out.println("Выберите Ваш статус: ");
                    gettStatus();



                    int chooseStatus = sc.nextInt();
                    switch (chooseStatus) {
                        case 1:
                            user.setStatus(Status.ВЗАИМНО);
                            break;
                        case 2:
                            user.setStatus(Status.В_ОЖИДАНИИ);
                            break;
                        case 3:
                            user.setStatus(Status.НЕ_ВЗАИМНО);
                            break;
                    }


                    user.setEmail(email);
                    user.setNumber(phoneNumber);
                    userService.createUser(user);
                    System.out.println("Вы успешно создали пользователя с именем " + userName);
                    break;
                case 2:
                    System.out.println("\n Список пользователей");
                    System.out.println(userService.getAllUsers());
                    break;



        }
    }
}