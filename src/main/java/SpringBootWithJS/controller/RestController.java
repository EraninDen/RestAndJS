package SpringBootWithJS.controller;

import SpringBootWithJS.service.UserService;
import SpringBootWithJS.model.Role;
import SpringBootWithJS.model.User;
import SpringBootWithJS.service.RoleService;
import SpringBootWithJS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public RestController(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;

    }


    @GetMapping("/admin/users1")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(this.userService.findAll());
    }


    @GetMapping("/admin/user1/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        try {
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/updateUser1/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/admin/updateUser1/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long id, @RequestBody User editUser) {
        User user = userService.findById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        HashSet<Role> roles = new HashSet<>();
        for (Role r : user.getRoles()) {
            roles.add(roleService.findByName(r.getRole()));
        }
        user.setRoles(roles);
        user.setUsername(editUser.getUsername());
        user.setPassword(editUser.getPassword());
        user.setFirstname(editUser.getFirstname());
        user.setLastname(editUser.getLastname());
        user.setRoles(editUser.getRoles());
        userService.update(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("/admin/user1/{id}")
    public boolean delete(@PathVariable Long id) {
        userService.deleteById(id);
        return true;
    }

    @PostMapping("/admin/user1")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.saveUser(user);
        User added = userService.findByName(user.getUsername());
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    @GetMapping("/admin/roles1")
    public ResponseEntity<List<Role>> getAllRoles() {
        return  ResponseEntity.ok().body(this.roleService.findAll());
    }


}
