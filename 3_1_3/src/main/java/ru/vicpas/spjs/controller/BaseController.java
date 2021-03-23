package ru.vicpas.spjs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vicpas.spjs.model.Role;
import ru.vicpas.spjs.model.User;
import ru.vicpas.spjs.service.userService.UserService;

import java.security.Principal;

@Controller
public class BaseController {

    private final UserService userService;

    @Autowired
    public BaseController(UserService userService) {

        this.userService = userService;
    }


    @GetMapping("/admin")
    public String adminPage(Model model) {

        String userLogin = getUserLogin();

        User user = userService.getByLogin(userLogin);

        StringBuilder sb = new StringBuilder();
        for (Role s : user.getUserRoles()) {
            sb.append(s);
            sb.append(", ");

        }
        sb.delete(sb.length() - 2, sb.length() - 1);

        model.addAttribute("user", user.getLogin());
        model.addAttribute("roles", sb);

        model.addAttribute("us", userService.getByLogin(userLogin));

        return "index";
    }

    @GetMapping("/user")
    public String onlyUserPage(Model model, Principal principal) {
        User currentUser = userService.getByLogin(principal.getName());
        model.addAttribute("user", currentUser);
        return "user";
    }


    public String getUserLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
