package com.example.springdemo002.generic;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

    @Autowired//类上不加注解，在类属性上加注解会使子类继承
    protected BaseRepository<T> repository;

    public void add(){
        System.out.println("add...");
        System.out.println(repository);
    }
}
