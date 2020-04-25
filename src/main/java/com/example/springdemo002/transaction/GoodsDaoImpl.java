package com.example.springdemo002.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    @Override
    public int findGoodsInventoryByGN(String GN) {
        String sql = "select 商品数量 from pro_test where 商品名 = ?;";
        return jdbcTemplate.queryForObject(sql,Integer.class,GN);
    }

    @Override
    public int findGoodsPriceByGN(String GN) {
        String sql = "select 商品价格 from pro_test where 商品名 = ?;";
        return jdbcTemplate.queryForObject(sql,Integer.class,GN);
    }

    @Override
    public void updateGoodsStockPlus(int number,String GN) {
        String sql = "update pro_test set 商品数量 = 商品数量 + ? where 商品名 = ?;";
        jdbcTemplate.update(sql,number,GN);
    }

    @Override
    public void updateGoodsStockSubtract(int number,String GN) {
        //先查看库存是否足够，若不够则抛出异常
        String sql0 = "select 商品数量 from pro_test where 商品名 = ?;";
        int 商品数量 = jdbcTemplate.queryForObject(sql0,Integer.class,GN);
        if(商品数量 < number){
            throw new GoodsException("库存不足");
        }

        String sql = "update pro_test set 商品数量 = 商品数量 - ? where 商品名 = ?;";
        jdbcTemplate.update(sql,number,GN);
    }

    @Override
    public void updateUserAccountPlus(double price,String name) {
        String sql = "update reader set balance = balance + ? where name = ?;";
        jdbcTemplate.update(sql,price,name);
    }

    @Override
    public void updateUserAccountSubtract(double price,String name) {
        //查看用户余额，若余额不足则抛出异常
        String sql0 = "select balance from reader where name = ?;";
        double balance = jdbcTemplate.queryForObject(sql0,Double.class,name);
        if(balance < price){
            throw new UserAccountException("余额不足");
        }

        String sql = "update reader set balance = balance - ? where name = ?;";
        jdbcTemplate.update(sql,price,name);
    }
}
