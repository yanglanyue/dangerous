package com.example.springdemo002.AOP.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
* 基于注解
* */
public class main {
    public static void main(String[] args) {
        //创建spring的IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器中bean的实例
        ArithmeticCalculator arithmeticCalculator = ac.getBean(ArithmeticCalculator.class);
        //使用bean
        int result = arithmeticCalculator.add(3,5);

        result = arithmeticCalculator.div(50,5);
    }
}
