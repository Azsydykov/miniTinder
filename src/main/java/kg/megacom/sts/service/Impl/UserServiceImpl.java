package kg.megacom.sts.service.Impl;
import kg.megacom.sts.dao.UserRep;
import kg.megacom.sts.models.User;
import kg.megacom.sts.service.UserService;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRep userRep = UserRep.INSTANCE;

    @Override
    public void createTable() throws SQLException {
        userRep.createTable();
    }
    @Override
    public User createUser(User user)  {
      try {
          userRep.save(user);
      }catch (SQLException throwables){
          throwables.printStackTrace();
      }
      return null;
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
}

