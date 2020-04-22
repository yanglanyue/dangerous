package com.example.springdemo002.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl2 implements UserRepository {

    @Override
    public void save() {
        System.out.println("UserRepositoryImpl2 save...");
    }
}
