package com.example.springdemo002.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GUAService implements GoodsUserAccountService {

    @Autowired
    private GoodsDao goodsDao;

//    尚硅谷-26-声明式事物，添加事物误解
    @Transactional
    @Override
    public void purchase(String name, String GN, int number) {
        //查询商品价格
        int price = goodsDao.findGoodsPriceByGN(GN)*number;

        //更新商品数量
        goodsDao.updateGoodsStockSubtract(number,GN);

        //减少用户余额
        goodsDao.updateUserAccountSubtract(price,name);

    }
}
