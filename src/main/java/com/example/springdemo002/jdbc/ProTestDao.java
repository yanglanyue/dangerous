package com.example.springdemo002.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//jdbcTemplate的具体用法（个方法代码在test文件夹下的JDBCTest测试类中）
@Repository
public class ProTestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProTest get(Integer id){
        String sql = "select * from pro_test where 商品ID = ?;";
        RowMapper<ProTest> rowMapper = new BeanPropertyRowMapper<>(ProTest.class);
        ProTest proTest = jdbcTemplate.queryForObject(sql,rowMapper,id);

        return proTest;
    }

}
