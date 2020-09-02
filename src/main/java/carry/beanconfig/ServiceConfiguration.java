package carry.beanconfig;

import carry.service.CatInfo;
import carry.service.CatInfoImpl;
import carry.service.UserInfo;
import carry.service.UserInfoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "carry")
public class ServiceConfiguration {


    @Bean
    public UserInfo userInfo(){
        UserInfoImpl userInfo = new UserInfoImpl();
        return userInfo;
    }

    @Bean
    public CatInfo catInfo(){
        CatInfoImpl catInfo = new CatInfoImpl();
        return catInfo;
    }
}
