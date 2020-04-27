package com.example.springdemo002.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CashierImpl implements Cashier {

    @Autowired
    private GoodsUserAccountServiceImpl goodsUserAccountService = null;

    @Transactional
    @Override
    public void checkout(String name, List<String> GNs,int i) {
        for (String GN:GNs){
            goodsUserAccountService.purchase(name,GN,i);
        }
    }
}
