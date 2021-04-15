package SpringBootWithJS.dao;

import SpringBootWithJS.model.User;

import java.util.List;

public interface UserDao  {
    User findById(Long id);

    User findByName(String username);

    List<User> findAll();

    User saveUser(User user);

    boolean deleteById(Long id);

    User update(User myUser);

}
