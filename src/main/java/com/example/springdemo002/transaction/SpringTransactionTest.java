package com.example.springdemo002.transaction;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.aspectj.bridge.MessageUtil.fail;

public class SpringTransactionTest {

    private ApplicationContext ac = null;
    private GoodsDao goodsDao = null;
    private GUAService guaService = null;

    {
        ac = new ClassPathXmlApplicationContext("beans-properties.xml");
        goodsDao = ac.getBean(GoodsDaoImpl.class);
        guaService = ac.getBean(GUAService.class);
    }

    @Test
    public void userBuyGoods(){
        guaService.purchase("王思聪","PS4",1);
    }

    //查询商品数量
    @Test
    public void testFindGoodsInventoryByGN(){
//        fail("fail...");
        System.out.println(goodsDao.findGoodsInventoryByGN("iphone11"));
    }

    //查询商品价格
    @Test
    public void testFindGoodsPriceByGN(){
        System.out.println(goodsDao.findGoodsPriceByGN("iphone11"));
    }

    //增加商品库存
    @Test
    public void testUpdateGoodsPlus(){
        goodsDao.updateGoodsStockPlus(100,"PS4");
    }

    //减少商品库存
    @Test
    public void testUpdateGoodsStock(){
        goodsDao.updateGoodsStockSubtract(2,"iphone11");
    }

    //增加用户余额
    @Test
    public void testUpdateUserAccountPlus() {
        goodsDao.updateUserAccountPlus(9999,"王思聪");
    }

    //扣除用户余额
    @Test
    public void testUpdateUserAccountSubtract() {
        goodsDao.updateUserAccountSubtract(10000,"马云");
    }
}
