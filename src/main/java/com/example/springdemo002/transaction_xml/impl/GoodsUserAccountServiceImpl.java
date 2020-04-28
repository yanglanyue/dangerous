package com.example.springdemo002.transaction_xml.impl;

import com.example.springdemo002.transaction_xml.GoodsDao;
import com.example.springdemo002.transaction_xml.service.GoodsUserAccountService;

public class GoodsUserAccountServiceImpl implements GoodsUserAccountService {

    private GoodsDao goodsDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public void purchase(String name, String GN, int number) {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //查询商品价格
        int price = goodsDao.findGoodsPriceByGN(GN)*number;

        //更新商品数量
        goodsDao.updateGoodsStockSubtract(number,GN);

        //减少用户余额
        goodsDao.updateUserAccountSubtract(price,name);

    }
}
