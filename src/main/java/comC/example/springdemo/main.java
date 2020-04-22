package comC.example.springdemo;

import comB.example.springdemo.autowire.Address;
import comB.example.springdemo.autowire.person;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-relation.xml");

        Address addressA = (Address) ac.getBean("addressA");
        System.out.println(addressA);

        addressA = (Address) ac.getBean("addressB");
        System.out.println(addressA);

        addressA = (Address) ac.getBean("addressD");
        System.out.println(addressA);

        person person = (person) ac.getBean("person1");
        System.out.println(person);

    }
}
