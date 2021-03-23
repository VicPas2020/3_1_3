package ru.vicpas.spjs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import ru.vicpas.spjs.model.Role;
import ru.vicpas.spjs.model.User;
import ru.vicpas.spjs.service.roleService.RoleService;
import ru.vicpas.spjs.service.userService.UserService;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpjsApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpjsApplication.class, args);

        openHomePage();

    }


    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:9090/admin");
    }


    @Order(1)
    @Bean
    public CommandLineRunner setOfRoles(RoleService roleRepo){
        return args -> {
            if(roleRepo.empty()) {
                roleRepo.save();
            }

        };

    }
    @Order(2)
    @Bean
    public CommandLineRunner minimalAdmin(UserService userRepo){
        return args-> {
            if(userRepo.empty()) {

                Set<Role> twoRoles = new HashSet<>();

                twoRoles.add(new Role(1L, "ROLE_ADMIN"));// можно роль запросить. Но мы прописываем явно
                twoRoles.add(new Role(2L, "ROLE_USER"));// можно роль запросить. Но мы прописываем явно

                Set<Role> user = new HashSet<>();
                user.add(new Role(2L, "ROLE_USER"));// можно роль запросить. Но мы прописываем явно


                Set<Role> admin = new HashSet<>();
                admin.add(new Role(1L, "ROLE_ADMIN"));// можно роль запросить. Но мы прописываем явно


//                PasswordEncoder pass = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//                String encodedPass = pass.encode("root");

                userRepo.add(new User("root",  "root" ,  "zeroAdmin",  "zeroAdmin",  100,  admin));
                userRepo.add(new User("root1", "root1" , "zeroAdmin1", "zeroAdmin1", 1001, twoRoles));
                userRepo.add(new User("root2", "root2" , "zeroAdmin2", "zeroAdmin2", 1002, twoRoles));
                userRepo.add(new User("root3", "root3" , "zeroAdmin3", "zeroAdmin3", 1003, user));
                userRepo.add(new User("root4", "root4" , "zeroAdmin4", "zeroAdmin4", 1004, user));
            }
        };

    }

}
