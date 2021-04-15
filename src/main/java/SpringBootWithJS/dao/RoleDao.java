package SpringBootWithJS.dao;

import SpringBootWithJS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, Long> {

    Role findByRole(String role);

    List<Role> findAll();
}
