package com.example.springdemo002.factory;

import java.util.HashMap;
import java.util.Map;

/*
* 尚硅谷spring4-11集
* 静态工厂方法：
* 直接调用某一个类的静态方法就可以返回bean的实例
* */
public class StaticCarFactory {

    private static Map<String,Car> cars = new HashMap<String, Car>();

    static {
        cars.put("NSX",new Car("Honda",330));
        cars.put("SLR",new Car("Benz",350));
        cars.put("GTR",new Car("Nissan",320));
        cars.put("911",new Car("Porsche",380));
    }

    //静态工厂方法
    public static Car getCar(String name){
        return cars.get(name);
    }
}
