package carry.beanconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan(basePackages = {"carry"})
public class WebConfiguraion {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }



//    @Bean
//    public FreeMarkerViewResolver  getFreeMarkerViewResolver(){
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setPrefix("/WEB-INF/ftl/");
//        resolver.setSuffix(".html");
//        resolver.setContentType("text/html;charset=UTF-8");
//        resolver.setCache(true);
//
//        return resolver;
//    }
//
//    @Bean
//    public FreeMarkerConfig getFreeMarkerConfig(){
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        return configurer;
//    }
}
