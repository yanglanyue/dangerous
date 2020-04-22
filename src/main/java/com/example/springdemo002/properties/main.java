package com.example.springdemo002.properties;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {

        SpringApplication.run(main.class, args);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans-properties.xml");

        DataSource dataSource = (DataSource) ac.getBean("dataSource");

        System.out.println(dataSource.getConnection());

    }
}
