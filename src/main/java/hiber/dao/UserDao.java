package hiber.dao;
import model.User;
import java.util.List;

public interface UserDao {
    List<User> printUsers();
    User showUserById(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);


}
