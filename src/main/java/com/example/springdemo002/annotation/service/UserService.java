package com.example.springdemo002.annotation.service;

import com.example.springdemo002.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    @Qualifier("userRepositoryImpl")
    /*
    遇到多个bean同时实现了同一个接口，而这些bean又没有从定义类名时，系统将会报错
    这时可手动指定要装配的bean，注意名称头字母小写
    */
    private UserRepository userRepository;

//    @Autowired
//    @Qualifier("userRepositoryImpl")
//    public void setUserRepository(@Qualifier("userRepositoryImpl")UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public void add(){
        System.out.println("UserService add...");
        userRepository.save();
    }
}
