package com.example.springdemo002.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

/*
* 不推荐此方式，比较麻烦，容易导致ProTestDao报错
* 必须添加累中的setDataSource2方法
* */
@Repository
public class ProTestDao2 extends JdbcDaoSupport {

    //以下错误不用管
    @Autowired
    public void setDataSource2(DataSource dataSource){
        setDataSource(dataSource);
    }

    public ProTestDao2 get(Integer id){
        String sql = "select * from pro_test where 商品ID = ?;";
        RowMapper<ProTestDao2> rowMapper = new BeanPropertyRowMapper<>(ProTestDao2.class);
        return getJdbcTemplate().queryForObject(sql,rowMapper,id);
    }
}
