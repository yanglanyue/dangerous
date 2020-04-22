package com.example.springdemo002.scope;

import com.example.springdemo002.entities.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-scope.xml");

        Car car1 = (Car)ac.getBean("car");
        Car car2 = (Car)ac.getBean("car");

        System.out.println(car1 == car2);

    }
}
