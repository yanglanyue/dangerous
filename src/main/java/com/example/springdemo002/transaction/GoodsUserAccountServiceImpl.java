package com.example.springdemo002.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsUserAccountServiceImpl implements GoodsUserAccountService {

    @Autowired
    private GoodsDao goodsDao;

//    尚硅谷-26-声明式事务，添加事物注解

    //尚硅谷-28-事务其他属性

    //添加事务注解
    //1.使用 propagation 指定事务的传播行为, 即当前的事务方法被另外一个事务方法调用时
    //如何使用事务, 默认取值为 REQUIRED, 即使用调用方法的事务
    //REQUIRES_NEW: 事务自己的事务, 调用的事务方法的事务被挂起.
    //2.使用 isolation 指定事务的隔离级别, 最常用的取值为 READ_COMMITTED
    //3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚. 也可以通过对应的
    //属性进行设置. 通常情况下去默认值即可.
    //4.使用 readOnly 指定事务是否为只读. 表示这个事务只读取数据但不更新数据,
    //这样可以帮助数据库引擎优化事务. 若真的是一个只读取数据库值的方法, 应设置 readOnly=true
    //5.使用 timeout 指定强制回滚之前事务可以占用的时间，单位：秒
    //	@Transactional(propagation=Propagation.REQUIRES_NEW,
    //			isolation=Isolation.READ_COMMITTED,
    //			noRollbackFor={UserAccountException.class})
    @Transactional(
            propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
//            readOnly = true,
            timeout = 2
                    )
    @Override
    public void purchase(String name, String GN, int number) {

        try {
            Thread.sleep(1000);
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
