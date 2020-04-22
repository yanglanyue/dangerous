package comlist.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    public static void main(String[] args) {

        SpringApplication.run(main.class, args);

        ApplicationContext ss = new ClassPathXmlApplicationContext("applicationContext.xml");

        person person = (person) ss.getBean("personP");
        System.out.println(person);
//
//        lady lady = (lady) ss.getBean("lady1");
//        System.out.println(lady);

//        DataSource dataSource = (DataSource) ss.getBean("p0");
//        System.out.println(dataSource.getProperties());
    }
}
