package kg.megacom.sts.service;
import kg.megacom.sts.models.User;
import kg.megacom.sts.service.Impl.UserServiceImpl;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    UserService INSTANCE = new UserServiceImpl();


    void createTable() throws SQLException;
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    public void deleteUser(int id);
    boolean changeStatus(User user, int userStatusCode);




}
