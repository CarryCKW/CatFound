package TestDao;

import carry.beanconfig.DaoConfiguration;
import carry.dao.CatDaoJdbcImpl;
import carry.repository.Cat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoConfiguration.class);
        CatDaoJdbcImpl catDaoJdbc = applicationContext.getBean(CatDaoJdbcImpl.class);
        System.out.println(catDaoJdbc.findAll().size());
    }
}
