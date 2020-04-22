package com.example.springdemo002.annotation.repository;

import com.example.springdemo002.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//可以为类指定你想要命名的名字，头字母注意大小写
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired(required = false)
    private TestObject testObject;

    @Override
    public void save(){
        System.out.println("UserRepositoryImpl save...");
        System.out.println(testObject);
    }
}
