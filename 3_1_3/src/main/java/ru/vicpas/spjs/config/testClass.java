package ru.vicpas.spjs.config;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;


//@Configuration
public class testClass {


    // номер 1
    /**
     * Будет исполнен раньше всех, после Initialized JPA EntityManagerFactory for persistence unit 'default'
     */
    @PostConstruct // depricated. Needs extra dependency
    void postConstruct() {
        System.out.println("\npostConstruct\n");
    }


    // номер 2
    /**
     * Выполняется перед Tomcat
     */
    @Order(3)
    @Bean
    public SmartInitializingSingleton importProcessor() {
        return () -> System.out.println("\nSmartInitializingSingleton\n");

    }



    // номер 4
    /**
     * Выполнится после Tomcat, но перед заупском приложения
     */
    @EventListener(ContextRefreshedEvent.class)
    public void doSomethingAfterStartup2() {
        System.out.println("\n@EventListener - ContextRefreshedEvent\n");
    }


    // номер 5
    /**
     * Выполнится в последнюю очередь, после запуска всего приложения, но перед @EventListener
     */
    @Bean
    public CommandLineRunner comm(){
        return args -> System.out.println("\nCommandLineRunner\n");
    }



    // номер 6
    /**
     *      * Выполнится в последнюю очередь, после запуска всего приложения , после CommandLineRunner
     */
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup1() {
        System.out.println("\n@EventListener - ApplicationReadyEvent\n");
    }




}

// номер 3
//@Component
  class OnStartServer2 implements ApplicationListener<ContextRefreshedEvent> {
//public class OnStartServer implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * Выполнится после Tomcat, но перед @EventListener - ContextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        System.out.println("OnStartServer2 implements ApplicationListener<ContextRefreshedEvent>");




    }

//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        System.out.println("ApplicationReadyEvent");
//    }
}

