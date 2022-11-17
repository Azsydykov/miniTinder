package kg.megacom.sts.dao.impl;
import kg.megacom.sts.dao.DbHelperRep;
import kg.megacom.sts.dao.UserRep;
import kg.megacom.sts.models.User;
import kg.megacom.sts.models.enums.Status;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepImpl implements UserRep {
    DbHelperRep dbHelperRep = DbHelperRep.INSTANCE;

    @Override
    public void createTable() throws SQLException {
        String sqlCreate = " CREATE TABLE IF NOT EXISTS " + "tb_users"
                + "  (ID         INTEGER, "
                + "   name       VARCHAR(50),"
                + "   age        INTEGER, "
                + "   definition      VARCHAR(255),"
                + "   email      VARCHAR(100), "
                + "   status     VARCHAR(50))";

        try (Statement stmt = dbHelperRep.connect().createStatement()) {
            stmt.execute(sqlCreate);
        }
    }

    @Override
    public void save(User user) throws SQLException {
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("insert into tb_users (name,age,definition,email,status)" +
                "VALUES (?, ?, ?, ?, ?)")) {

            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getDefinition());
            ps.setString(4, user.getEmail());
            ps.setString(5, String.valueOf(user.getStatus()));
            ps.executeUpdate();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("select * from tb_users")) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setDefinition(resultSet.getString("definition"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(Status.valueOf(resultSet.getString("status")));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        try ( PreparedStatement ps = dbHelperRep.connect().prepareStatement("select * from tb_users where id= ?")){
            ps.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = ps.executeQuery();
            User user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setDefinition(resultSet.getString("definition"));
                user.setEmail(resultSet.getString("email"));
                user.setStatus(Status.valueOf(resultSet.getString("status")));
            }
            return user;
        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе пользователя!");
        }
    }

    @Override
    public void deleteUser(int id) {
        try (PreparedStatement ps = dbHelperRep.connect().prepareStatement("delete from tb_users where id=?")){
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Пользователь успешно удалён.");

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении пользователя!");
        }
    }
}