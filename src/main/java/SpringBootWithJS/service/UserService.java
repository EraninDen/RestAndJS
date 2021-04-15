package SpringBootWithJS.service;

import SpringBootWithJS.dao.UserDao;
import SpringBootWithJS.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findById(Long id){
        return userDao.findById(id);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User saveUser (User user){
        return userDao.saveUser(user);
    }

    public boolean deleteById (Long id){
       return userDao.deleteById(id);
    }

    public User findByName( String username){
        return userDao.findByName(username);
    }

    public User update(User user){
        return userDao.update(user);
    }

}
