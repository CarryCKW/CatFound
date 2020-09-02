package carry.controller;

import carry.dao.CatDao;
import carry.repository.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CatDao catDaoJdbc;

    @RequestMapping(value = {"/"})
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response, Model model){
        ModelAndView view = new ModelAndView("realhomepage");
//        List<Cat> catList = catDaoJdbc.findAll();
//        view.addObject("catlist",catList);
        return view;
    }

    @RequestMapping(value = "/homepage")
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response, Model model){
        ModelAndView view = new ModelAndView("homepage");
        List<Cat> catList = catDaoJdbc.findAll();
        view.addObject("catlist",catList);
        return view;
    }


}
