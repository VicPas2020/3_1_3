package ru.vicpas.spjs.service.userService;

//import org.springframework.stereotype.Service;
import ru.vicpas.spjs.model.User;

import java.util.List;

//@Service
public interface UserService  {

    void add   (User user);
    void delete(User user);
    void edit  (User user);


    User getById   (Long id);
    User getByLogin(String login);
    List<User> getAllUsers();

    boolean empty();

}
