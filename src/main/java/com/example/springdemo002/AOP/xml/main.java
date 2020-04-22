package com.example.springdemo002.AOP.xml;

import org.aspectj.lang.JoinPoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
* 基于配置文件
* */
public class main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ac.getBean("arithmeticCalculator");

        int result = arithmeticCalculator.add(3,5);
//        System.out.println(result);

        result = arithmeticCalculator.div(50,5);
//        System.out.println(result);

    }
}
