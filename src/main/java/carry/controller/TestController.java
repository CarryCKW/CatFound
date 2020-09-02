package carry.controller;


import carry.beanconfig.DaoConfiguration;
import carry.dao.CatDao;
import carry.dao.CatDaoJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//没用的
@Controller
public class TestController {

    @Autowired
    private CatDao catDaoJdbc;

    @RequestMapping("/showcats")
    public ModelAndView showcats(){
        //CatDaoJdbcImpl catDaoJdbc = ContextLoader.getCurrentWebApplicationContext().getBean(CatDaoJdbcImpl.class);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        modelAndView.addObject("cat",catDaoJdbc.find(1L));
        //System.out.println(catDaoJdbc.find(1L).getName());
        return modelAndView;
    }





}
