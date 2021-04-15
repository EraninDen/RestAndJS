package SpringBootWithJS.service;

import SpringBootWithJS.dao.RoleDao;
import SpringBootWithJS.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Role findById(Long id){
        return roleDao.getOne(id);
    }


    public Role findByName(String role){
        return roleDao.findByRole(role);
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
