package com.example.springdemo002.annotation;

import com.example.springdemo002.annotation.controller.UserController;
import com.example.springdemo002.annotation.repository.UserRepository;
import com.example.springdemo002.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-annotation.xml");

//        TestObject to = (TestObject) ac.getBean("testObject");
//        System.out.println(to);

        UserController uc = (UserController) ac.getBean("userController");
//        System.out.println(uc);
        uc.execute();

//        UserService us = (UserService) ac.getBean("userService");
//        System.out.println(us);
//
//        UserRepository ur = (UserRepository) ac.getBean("userRepository");
//        System.out.println(ur);
    }
}
