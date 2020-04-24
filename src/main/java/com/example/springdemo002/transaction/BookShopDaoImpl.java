package com.example.springdemo002.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    @Override
    public int findGoodsPriceByGN(String GN) {
        String sql = "select 商品价格 from pro_test where 商品名 = ?;";
        return jdbcTemplate.queryForObject(sql,Integer.class,GN);
    }

    @Override
    public void updateGoodsStock(String GN) {
        String sql = "update pro_test set 商品数量 = 商品数量 - 1 where 商品名 = GN;";
        jdbcTemplate.update(sql,GN);
    }

    @Override
    public void updateUserAccount(String name, int price) {
        String sql = "update reader set balance = balance - ? where name = ?;";
        jdbcTemplate.update(sql,name,price);
    }
}
