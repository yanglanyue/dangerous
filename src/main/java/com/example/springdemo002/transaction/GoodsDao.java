package com.example.springdemo002.transaction;

public interface GoodsDao {

    //根据商品名获取商品数量
    public int findGoodsInventoryByGN(String GN);

    //根据商品名获取商品价格
    public int findGoodsPriceByGN(String GN);

    //根据商品名增加商品库存
    public void updateGoodsStockPlus(int number,String GN);

    //根据商品名减少商品库存
    public void updateGoodsStockSubtract(int number,String GN);

    //更新用户余额
    public void updateUserAccountPlus(double price,String name);

    //更新用户余额，扣除，余额（balance）-书的价格（price）
    public void updateUserAccountSubtract(double price,String name);
}
