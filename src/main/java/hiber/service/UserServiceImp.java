package hiber.service;

import hiber.dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
@Component
public class UserServiceImp implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> printUsers() {
        return userDao.printUsers();
    }

    @Override
    public User showUserById(int id) {
        return userDao.showUserById(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
