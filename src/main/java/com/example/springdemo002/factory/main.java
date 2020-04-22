package com.example.springdemo002.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(com.example.springdemo002.properties.main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-factory.xml");

        Car car = (Car) ac.getBean("car3");

        System.out.println(car);

    }
}
