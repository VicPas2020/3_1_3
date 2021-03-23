package ru.vicpas.spjs.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vicpas.spjs.model.User;
import ru.vicpas.spjs.repository.UserRepo;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class userServiceSpringDataJPAImpl implements UserService{

    //................. Fields and Constructors .................
    private UserRepo userRepo;

    public userServiceSpringDataJPAImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    //TODO: ПРОВЕРКА НА ("ПОЛЬЗОВАТЕЛЬ С ТАКИМ ИМЕНЕМ УЖЕ СУЩЕСТВУЕТ");
    //TODO: почему работает только если заинжектить поле, но НЕ через конструктор ?????????????????????????????

    @Autowired
    private PasswordEncoder passwordEncoder;


    //.................  Methods .............................
    @Override
    @Transactional
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // part of business logic
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userRepo.delete(user);
    }


    @Override
    @Transactional
    public void edit(User user) {
        userRepo.save(user);

    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    //Transactional
    public User getByLogin(String loginIN) {
        return userRepo.findByLogin(loginIN);
    }

    @Override
    public List<User> getAllUsers() {
      return (List<User>) userRepo.findAll();
    }


    public List<User> getAllUsersSorted() {
        List<User> list = (List<User>) userRepo.findAll();
        list.sort(Comparator.comparing(User::getFirstName));
        return list;
    }

    @Override
    public boolean empty() {
        return userRepo.count()==0;
    }

}
