package com.example.springdemo002.AOP.helloworld;
/*
* 基于动态代理
* */
public class main {
    public static void main(String[] args) {
//        ArithmeticCalculator arithmeticCalculator = null;
//        arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();

        ArithmeticCalculator target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        int result = proxy.add(8,5);
        System.out.println("-->" + result);

        result = proxy.div(43,1);
        System.out.println("-->" + result);

    }
}
