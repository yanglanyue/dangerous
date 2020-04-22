package com.example.springdemo002.factory;

import java.util.HashMap;
import java.util.Map;

/*
 * 尚硅谷spring4-11集
 * 实例工厂方法：
 * 先创立工厂本身，在调用工厂的实例方法来返回bean
 * */
public class InstanceCarFactory {

    Map<String,Car> cars = null;

    public InstanceCarFactory(){
        cars = new HashMap<String, Car>();
        cars.put("M6",new Car("BMW",290));
        cars.put("C63",new Car("Benz",320));
        cars.put("RX7",new Car("Mazda",280));
        cars.put("Supra",new Car("Toyota",280));
    }

    public Car getCar(String brand){
        return cars.get(brand);
    }
}
