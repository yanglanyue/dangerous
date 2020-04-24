package com.example.springdemo002.transaction;

public interface BookShopDao {

    //根据商品名获取商品价格
    public int findGoodsPriceByGN(String GN);

    //根据商品名更新商品库存，使相应的商品-1
    public void updateGoodsStock(String GN);

    //更新用户的账户余额，余额（balance）-书的价格（price）
    public void updateUserAccount(String name,int price);
}
