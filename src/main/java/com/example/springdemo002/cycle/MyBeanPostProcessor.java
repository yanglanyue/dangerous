package com.example.springdemo002.cycle;

/*
* Spring4视频教程-10管理bean的生命周期-08:28
* bean的后置处理器
* */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + bean + ","+beanName);
        if("car".equals(beanName)){
            //...
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + bean + ","+beanName);
        Car car = new Car();
        car.setBrand("Honda");
        return car;
//        return bean;
    }
}
