package com.example.springdemo002.transaction_xml;

import com.example.springdemo002.transaction_xml.service.Cashier;
import com.example.springdemo002.transaction_xml.impl.GoodsUserAccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {

    private ApplicationContext ac = null;
    private GoodsDao goodsDao = null;
    private GoodsUserAccountServiceImpl guaService = null;
    private Cashier cashier = null;

    {
        ac = new ClassPathXmlApplicationContext("beans-transaction-xml.xml");
        goodsDao = ac.getBean(GoodsDaoImpl.class);
        guaService = ac.getBean(GoodsUserAccountServiceImpl.class);
        cashier = ac.getBean(Cashier.class);
    }

    @Test
    public void testTransactionPropagation(){
        cashier.checkout("张学友", Arrays.asList("PS4","PS4 Pro"),1);
    }

    @Test
    public void userBuyGoods(){
        guaService.purchase("王思聪","AirPods",2);
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
        goodsDao.updateGoodsStockPlus(5,"PS4");
    }

    //减少商品库存
    @Test
    public void testUpdateGoodsStock(){
        goodsDao.updateGoodsStockSubtract(2,"iphone11");
    }

    //增加用户余额
    @Test
    public void testUpdateUserAccountPlus() {
        goodsDao.updateUserAccountPlus(99999,"王思聪");
    }

    //扣除用户余额
    @Test
    public void testUpdateUserAccountSubtract() {
        goodsDao.updateUserAccountSubtract(10000,"马云");
    }
}
