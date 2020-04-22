package com.example.springdemo002.FactoryBean;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(com.example.springdemo002.properties.main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-FactoryBean.xml");

        Car car = (Car) ac.getBean("car1");

        System.out.println(car);

    }
}
