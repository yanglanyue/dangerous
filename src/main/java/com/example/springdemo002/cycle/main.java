package com.example.springdemo002.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-cycle.xml");

        Car car = (Car) ac.getBean("car");
        System.out.println(car);

        //关闭IOC容器
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
