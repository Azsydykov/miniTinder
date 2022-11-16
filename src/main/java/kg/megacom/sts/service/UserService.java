package kg.megacom.sts.service;

import kg.megacom.sts.models.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    public List<User> getAllUsers();

    User getUserById(Long id);

    public void deleteUser(int id);
 //   void updateStatus(int id);


}
