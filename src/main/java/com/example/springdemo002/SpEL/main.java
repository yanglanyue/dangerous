package com.example.springdemo002.SpEL;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-SpEL.xml");

        Address address = (Address) ac.getBean("address");
        System.out.println(address);

        Car car = (Car) ac.getBean("car");
        System.out.println(car);

        person person = (person) ac.getBean("person");
        System.out.println(person);

    }
}
