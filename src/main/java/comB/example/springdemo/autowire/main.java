package comB.example.springdemo.autowire;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-autowire.xml");

        person person = (person) ac.getBean("personA");
        System.out.println(person);

    }
}
