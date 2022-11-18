package kg.megacom.sts.dao;

import kg.megacom.sts.dao.impl.UserRepImpl;
import kg.megacom.sts.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRep {
    UserRep INSTANCE = new UserRepImpl();
    void createTable() throws SQLException;
    void save(User user) throws SQLException;
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(int id);
    User findByEmail(String email) throws SQLException;



}
