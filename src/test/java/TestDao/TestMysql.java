package TestDao;

import carry.beanconfig.DaoConfiguration;
import carry.dao.CatDaoJdbcImpl;
import carry.repository.Cat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMysql {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoConfiguration.class);
        CatDaoJdbcImpl catDaoJdbc = applicationContext.getBean(CatDaoJdbcImpl.class);
        Cat cat = catDaoJdbc.find(1L);
        System.out.println(cat.getName());
    }
}
