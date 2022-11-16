package kg.megacom.sts.service.Impl;
import kg.megacom.sts.dao.DbHelper;
import kg.megacom.sts.models.Status;
import kg.megacom.sts.models.User;
import kg.megacom.sts.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    DbHelper dbHelper = new DbHelper();
    List<User> userList = new ArrayList<>();


    @Override
    public void createUser(User user) {
        try {
            Connection conn = dbHelper.connection();
            PreparedStatement ps = conn.prepareStatement("insert into tb_users (name,age,diff,email,number,status) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getDiff());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getNumber());
            ps.setString(6, String.valueOf(user.getStatus()));

            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Обьект успешно добавлен");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при добавлении пользователя");
        }

    }

    @Override
    public List<User> getAllUsers() {

        try {
            Connection conn = dbHelper.connection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM tb_users");
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setDiff(resultSet.getString("diff"));
                user.setEmail(resultSet.getString("email"));
                user.setNumber(resultSet.getString("number"));
                user.setStatus(Status.valueOf(resultSet.getString("status")));

                userList.add(user);
            }
            return userList;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка пользователей");
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            Connection conn = dbHelper.connection();
            PreparedStatement ps = conn.prepareStatement("select * from tb_users where id= ?");
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setDiff(resultSet.getString("diff"));
                user.setEmail(resultSet.getString("email"));
                user.setNumber(resultSet.getString("number"));
                user.setStatus(Status.valueOf(resultSet.getString("status")));

            }
            return user;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе пользователя!");
        }
    }

    @Override
    public void deleteUser(int id) {
        try {
            Connection conn = dbHelper.connection();
            PreparedStatement ps = conn.prepareStatement("delete from tb_users where id=?");
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Пользователь успешно удалён");
            } else if (result == 0) {
                System.out.println("Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении пользователя!");
        }
    }

}
