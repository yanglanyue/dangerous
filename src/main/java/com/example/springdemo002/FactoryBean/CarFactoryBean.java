package com.example.springdemo002.FactoryBean;

import org.springframework.beans.factory.FactoryBean;

/*
 * 尚硅谷spring4-12集
 * 需要实现spring自帶的FactoryBean接口
 * */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回bean的对象
    @Override
    public Car getObject() throws Exception {
        return new Car(brand,280);
    }

    //返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
