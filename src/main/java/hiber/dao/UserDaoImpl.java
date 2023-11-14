package hiber.dao;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//@Component
@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> printUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        User userToBeUpdate = showUserById(id);
        userToBeUpdate.setFirstName(updatedUser.getFirstName());
        userToBeUpdate.setLastName(updatedUser.getLastName());
        userToBeUpdate.setPassportNumberSeries(updatedUser.getPassportNumberSeries());
    }

    @Override
    @Transactional
    public void delete(int id) {
        User deleteUser = entityManager.find(User.class, id);
        if (deleteUser != null) {
            entityManager.remove(deleteUser);
        }
    }
}
