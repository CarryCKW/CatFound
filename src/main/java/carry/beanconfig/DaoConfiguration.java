package carry.beanconfig;

import carry.dao.CatDao;
import carry.dao.CatDaoJdbcImpl;
import carry.dao.UserDao;
import carry.dao.UserDaoJdbcImpl;
import carry.service.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DaoConfiguration{

    @Bean
    public PlatformTransactionManager platformTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public UserDao userDao(){
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.setJdbcTemplate(jdbcTemplate());
        return userDaoJdbc;
    }

    @Bean
    public CatDao catDao(){
        CatDaoJdbcImpl catDaoJdbc = new CatDaoJdbcImpl();
        catDaoJdbc.setJdbcTemplate(jdbcTemplate());
        return catDaoJdbc;
    }

    //H2
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//        driverManagerDataSource.setDriverClassName("org.h2.Driver");
//        driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
//        driverManagerDataSource.setUsername("sa");
//        driverManagerDataSource.setPassword("");
//        return driverManagerDataSource;
//    }
//
    //Mysql
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        String name = "root";
        String pwd = ".ckw5819wkc";
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/catfound?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT");
        driverManagerDataSource.setUsername(name);
        driverManagerDataSource.setPassword(pwd);
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }



}
