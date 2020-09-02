package TestDao;

import carry.beanconfig.DaoConfiguration;
import carry.dao.UserDaoJdbcImpl;
import carry.repository.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoConfiguration.class);
        UserDaoJdbcImpl userDaoJdbc = applicationContext.getBean(UserDaoJdbcImpl.class);
        User user = userDaoJdbc.find("ckw");
        System.out.println(user.getPassword());
    }
}
