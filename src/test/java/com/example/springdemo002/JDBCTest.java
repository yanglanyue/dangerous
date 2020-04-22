package com.example.springdemo002;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCTest {

    private ApplicationContext ac = null;
    private JdbcTemplate jdbcTemplate;

    {
        ac = new ClassPathXmlApplicationContext("beans-properties.xml");
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
    }

    @Test
    public void testBatchUpdate(){
        String sql = "insert into pro_test(商品ID, 商品名, 商品数量) values(?,?,?);";

        List<Object[]>  batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{36,"B&O E6",20});
        batchArgs.add(new Object[]{37,"B&O E8",20});
        batchArgs.add(new Object[]{38,"B&O E10",20});
        batchArgs.add(new Object[]{39,"B&O H1",20});
        batchArgs.add(new Object[]{40,"B&O H6",20});

        jdbcTemplate.update(sql,"RX8",720000,35);
    }

    @Test
    public void testUpdate(){
        String sql = "update pro_test set 商品名 = ? , 商品价格 = ? where 商品ID = ?;";
        jdbcTemplate.update(sql,"RX8",720000,35);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ac.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
