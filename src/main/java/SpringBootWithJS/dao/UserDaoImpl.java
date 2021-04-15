package SpringBootWithJS.dao;

import SpringBootWithJS.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByName(String username) {
        return entityManager
                .createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        return entityManager
                .createQuery("delete from User u where u.id=:id")
                .setParameter("id", id).executeUpdate()==1;
    }

    @Override
    @Transactional
    public User update(User user) {
        final User updated = entityManager.merge(user);
        entityManager.flush();
        return updated;
    }
}