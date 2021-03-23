package ru.vicpas.spjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vicpas.spjs.model.Dto;
import ru.vicpas.spjs.model.Role;
import ru.vicpas.spjs.model.User;
import ru.vicpas.spjs.service.roleService.RoleService;
import ru.vicpas.spjs.service.userService.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    //private final static Logger logger = Logger.getLogger("getClass()");
    //..............  FIELDS and CONSTRUCTORS

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public RestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    //.......... CONTROLLERS...............
    @GetMapping("/admin/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("admin/oneUser") //  для Edit Modal
    public User getOneUser(@RequestParam(value = "login") String login) {
        return userService.getByLogin(login);
    }


    @GetMapping("admin/oneUserID") //  для Edit Modal
    public User getOneUserByID(@RequestParam(value = "id") Long id) {
        return userService.getById(id);
    }


    @PostMapping("admin/post")
    public void addNewUser(@RequestBody Dto dto

    ) {

        Set<Role> set = new HashSet<>();
        String rawRole = dto.getRolesInString().toString();

        if(rawRole != null && rawRole.contains("ROLE_ADMIN")) {
            set.add(roleService.getRoleByRoleName("ROLE_ADMIN"));
        }
        if(rawRole != null && rawRole.contains("ROLE_USER")) {
            set.add(roleService.getRoleByRoleName("ROLE_USER"));
        }

        User user = new User(dto);
        user.setUserRoles(set);
        userService.add(user);
    }


    @PutMapping("admin/put")
    public void editUser(@RequestBody Dto dto) {

        Set<Role> set = new HashSet<>();
        String rawRole = dto.getRolesInString().toString();

        if(rawRole != null && rawRole.contains("ROLE_ADMIN")) {
            set.add(roleService.getRoleByRoleName("ROLE_ADMIN"));
        }
        if(rawRole != null && rawRole.contains("ROLE_USER")) {
            set.add(roleService.getRoleByRoleName("ROLE_USER"));
        }

        User user = new User(dto);
        user.setUserRoles(set);
        userService.edit(user);
    }

    @DeleteMapping("admin/delete")
    public void deleteUser(@RequestParam(value = "id") Long id) {
        userService.delete(userService.getById(id));

    }

}
