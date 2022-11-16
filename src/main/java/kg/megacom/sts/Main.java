package kg.megacom.sts;

import kg.megacom.sts.dao.DbHelper;
import kg.megacom.sts.service.CrudOperationService;
import kg.megacom.sts.service.Impl.CrudOperationServiceImpl;
import kg.megacom.sts.service.Impl.UserServiceImpl;
import kg.megacom.sts.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DbHelper dbHelper = new DbHelper();
        CrudOperationService crudOperationService = new CrudOperationServiceImpl();


        System.out.println("Зайти как админ - 0");
        System.out.println("Зайти как пользователь - 1");

        switch (sc.nextInt()) {
            case 0:
                crudOperationService.crudObjects();
                break;
            case 1:
                crudOperationService.userCreating();
                break;
        }
    }
}
