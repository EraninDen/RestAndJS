package SpringBootWithJS.controller;

import SpringBootWithJS.service.RoleService;
import SpringBootWithJS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {

        this.userService = userService;
        this.roleService = roleService;

    }

    @GetMapping
    public String hello(){
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String getAdmin(@RequestParam(required = false) String username, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        boolean hasAdmin;
        if (roles.contains("ROLE_ADMIN")){
            hasAdmin=true;
        } else {
            hasAdmin=false;
        }
        model.addAttribute("hasAdmin", hasAdmin);
        model.addAttribute("username", name);
        model.addAttribute("user", userService.findByName(name));

        return "/admin";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam(required = false) String username,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        boolean hasAdmin;
        if(roles.contains("ROLE_ADMIN")){
            hasAdmin=true;
        } else {
            hasAdmin=false;
        }
        model.addAttribute("hasAdmin", hasAdmin);
        model.addAttribute("username", name);
        model.addAttribute("user", userService.findByName(name));
        return "user";
    }

}
