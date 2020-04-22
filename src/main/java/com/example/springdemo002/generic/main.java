package com.example.springdemo002.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//尚硅谷15集
//泛型依赖注入

public class main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-generic.xml");

        UserService userService = (UserService) ac.getBean("userService");
        userService.add();

    }
}
