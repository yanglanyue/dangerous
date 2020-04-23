package com.example.springdemo002;


import com.example.springdemo002.jdbc.ProTest;
import com.example.springdemo002.jdbc.ProTestDao;
import com.example.springdemo002.jdbc.ProTestDao2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCTest {

    private ApplicationContext ac = null;
    private JdbcTemplate jdbcTemplate;
    private ProTestDao proTestDao;
    private ProTestDao2 proTestDao2;

    {
        ac = new ClassPathXmlApplicationContext("beans-properties.xml");
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
        proTestDao = ac.getBean(ProTestDao.class);
        proTestDao2 = ac.getBean(ProTestDao2.class);
    }

//    不推荐继承JdbcDaoSupport方式，推荐使用JdbcTemplate作为Dao类的成员变量
//    JdbcTemplate方式
    @Test
    public void testProTestDao(){
        System.out.println(proTestDao.get(1));
    }
//    JdbcDaoSupport方式
    @Test
    public void testProTestDao2(){
        System.out.println(proTestDao2.get(1));
    }

    /*
     * 查询单个列的值
     * */
    @Test
    public void testQueryForObject2(){
        String sql = "select count(生产日期) from pro_test;";
        Long count = jdbcTemplate.queryForObject(sql,Long.class);

        System.out.println(count);
    }

    /*
    * 查询实体类的集合
    * */
    @Test
    public void testQueryForList(){
        String sql = "select 商品ID from pro_test where 商品ID > ?;";
        RowMapper<ProTest> rowMapper = new BeanPropertyRowMapper<>(ProTest.class);
        List<ProTest> proTests = jdbcTemplate.query(sql,rowMapper,34);

        System.out.println(proTests);
    }

    /*
    * 从数据库中获取一条记录，得到对应的对象，类似ORM框架
    * 注意：不是调用jdbcTemplate.queryForObject(sql,ProTest.class,"1");方法
    * */
    @Test
    public void testQueryForObject(){
        String sql = "select * from pro_test where 商品ID = ?;";
        RowMapper<ProTest> rowMapper = new BeanPropertyRowMapper<>(ProTest.class);
        ProTest proTest = jdbcTemplate.queryForObject(sql,rowMapper,"1");
        System.out.println(proTest);
    }
    /*
    * 执行批量更新
    * 最后一个参数是Object[] 的List类型
    * */
    @Test
    public void testBatchUpdate(){
        String sql = "insert into pro_test(商品ID, 商品名, 商品数量) values(?,?,?);";

        List<Object[]>  batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{36,"B&O E6",20});
        batchArgs.add(new Object[]{37,"B&O E8",20});
        batchArgs.add(new Object[]{38,"B&O E10",20});
        batchArgs.add(new Object[]{39,"B&O H1",20});
        batchArgs.add(new Object[]{40,"B&O H6",20});

        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Test
    public void testUpdate(){
        String sql = "update pro_test set 商品名 = ? , 商品价格 = ? where 商品ID = ?;";
        jdbcTemplate.update(sql,"RX8",720000,35);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ac.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
