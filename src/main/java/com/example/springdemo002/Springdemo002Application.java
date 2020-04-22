package com.example.springdemo002;

import com.example.springdemo002.entities.Car;
import com.example.springdemo002.entities.hello;
import com.example.springdemo002.entities.person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Springdemo002Application {

    public static void main(String[] args) {
        SpringApplication.run(Springdemo002Application.class, args);

        ApplicationContext ss = new ClassPathXmlApplicationContext("applicationContext.xml");

        hello hello = (hello) ss.getBean("hello");
        hello.helloWorld();

        Car car = (Car) ss.getBean("car1");
        person person = (person) ss.getBean("person6");
        System.out.println(car);
        System.out.println(person);
    }

}
