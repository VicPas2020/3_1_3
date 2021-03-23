package ru.vicpas.spjs.repository;

import org.springframework.data.repository.CrudRepository;
import ru.vicpas.spjs.model.User;

//@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByLogin(String username);



}
