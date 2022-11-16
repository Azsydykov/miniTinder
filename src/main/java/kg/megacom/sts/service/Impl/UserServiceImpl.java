package kg.megacom.sts.service.Impl;
import kg.megacom.sts.dao.UserRep;
import kg.megacom.sts.models.User;
import kg.megacom.sts.service.UserService;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserRep userRepImpl = UserRep.INSTANCE;

    @Override
    public void createTable() throws SQLException {
        userRepImpl.createTable();
    }
    @Override
    public User createUser(User user)  {
      try {
          userRepImpl.save(user);
      }catch (SQLException throwables){
          throwables.printStackTrace();
      }
      return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepImpl.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}

