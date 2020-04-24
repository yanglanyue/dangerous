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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCTest {

    private ApplicationContext ac = null;
    private JdbcTemplate jdbcTemplate;
    private ProTestDao proTestDao;
    private ProTestDao2 proTestDao2;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ac = new ClassPathXmlApplicationContext("beans-properties.xml");
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
        proTestDao = ac.getBean(ProTestDao.class);
        proTestDao2 = ac.getBean(ProTestDao2.class);
        namedParameterJdbcTemplate = ac.getBean(NamedParameterJdbcTemplate.class);
    }


    //尚硅谷-24-使用NamedParameterJdbcTemplate，该对象可以使用具名参数，可以对参数起名字
    //方法一
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "insert into pro_test(商品ID, 商品名, 商品数量) values(:a,:b,:c);";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("a","100");
        paramMap.put("b","iPad Pro 2020");
        paramMap.put("c","30");

        namedParameterJdbcTemplate.update(sql,paramMap);
    }
    /*
    * 方法二
    * SQL语句中的参数名和类的属性名一致
    * 使用SqlParameterSource接口的实现类BeanPropertySqlParameterSource(proTest)
    * */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "insert into pro_test(商品ID, 商品名, 商品价格, 供应商, 商品数量) values(:商品ID,:商品名,:商品价格,:供应商,:商品数量);";
        ProTest proTest = new ProTest();
        proTest.set商品ID(102);
        proTest.set商品名("iphone SE");
        proTest.set商品价格(3298);
        proTest.set供应商("苹果公司");
        proTest.set商品数量(100);

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(proTest);
        namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }

//    不推荐继承JdbcDaoSupport方式，推荐使用JdbcTemplate作为Dao类的成员变量
//    JdbcTemplate方式（jdbc包下的ProTestDao）
    @Test
    public void testProTestDao(){
        System.out.println(proTestDao.get(1));
    }
//    JdbcDaoSupport方式（jdbc包下的ProTestDao2）
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
