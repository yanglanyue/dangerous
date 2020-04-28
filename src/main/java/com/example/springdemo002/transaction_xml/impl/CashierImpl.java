package com.example.springdemo002.transaction_xml.impl;

import com.example.springdemo002.transaction_xml.service.Cashier;

import java.util.List;

public class CashierImpl implements Cashier {

    private GoodsUserAccountServiceImpl goodsUserAccountService = null;

    public void setGoodsUserAccountService(GoodsUserAccountServiceImpl goodsUserAccountService) {
        this.goodsUserAccountService = goodsUserAccountService;
    }

    @Override
    public void checkout(String name, List<String> GNs,int i) {
        for (String GN:GNs){
            goodsUserAccountService.purchase(name,GN,i);
        }
    }
}
