package com.example.springdemo002.AOP.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

//动态代理

public class ArithmeticCalculatorLoggingProxy {

    //要代理的对象
    ArithmeticCalculator target;

    public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy(){

        ArithmeticCalculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，既其中有哪些方法
        Class [] interfaces = new Class[]{ArithmeticCalculator.class};
        //当调用代理对象执行其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /*
            * proxy：正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象
            * method：正在被调用的方法
            * args：调用方法时传入的参数
            **/
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //打印日志
                System.out.println("Method：" + methodName + " /Argument：" + Arrays.asList(args));
                //调用目标方法
                Object result = null;
                try {
                    //前置通知
                    result = method.invoke(target,args);
                    //返回通知，可以访问到方法的返回值
                }catch (Exception e){
                    e.printStackTrace();
                    //异常通知，可以访问到方法出现的异常
                }

                //后置通知，因为方法可能会出异常，所有访问不到方法的返回值
                //打印日志
                System.out.println("Result：" + result);
                return result;
            }
        };
        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
