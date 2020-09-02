package carry.controller;


import carry.repository.User;
import carry.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@Controller
public class LoginAndRegistController {


    @Autowired
    private UserInfo userInfo;

    @RequestMapping("/registForm")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response, Model model){
        ModelAndView view = new ModelAndView("registForm");
        view.addObject("user",new User());
        return view;
    }

    @RequestMapping(value = "/home")
    public void afterRegister(HttpServletRequest request, HttpServletResponse response,  @Validated User user, BindingResult result) throws IOException {
        System.out.println("after register");
        //1.查看用户注册信息，并存入数据库，加入事务检查
        String username = user.getName();
        String userpassword = user.getPassword();
        System.out.println("username= " + username);
        System.out.println("password= " + userpassword);

        if(result.hasErrors()){
            response.sendRedirect(request.getContextPath()+"/registForm");
        }else{
            //存入数据库，二次检查，跳转 /home
            if(!userInfo.isExist(username)){
                if(username!=null&&username!=""&&userpassword!=null&&userpassword!=""){
                    username = URLEncoder.encode(username,"utf-8");
                    response.addCookie(new Cookie("name",username));
                    userInfo.addUser(user);
                    response.sendRedirect(request.getContextPath()+"/homepage");
                }else {
                    response.sendRedirect(request.getContextPath()+"/registForm");
                }
            }else {
                response.sendRedirect(request.getContextPath()+"/registForm");
            }
        }
    }

    @RequestMapping(value = "/loginForm")
    public ModelAndView login(){
        ModelAndView view = new ModelAndView("loginForm");
        view.addObject("user",new User());
        return view;
    }

    @RequestMapping(value = "/login")
    public void afterLogin(HttpServletRequest request, HttpServletResponse response,  @Validated User user, BindingResult result) throws IOException {
        System.out.println("after login");
        String username = user.getName();
        String userpassword = user.getPassword();
        System.out.println("username= " + username);
        System.out.println("password= " + userpassword);

        try {
            if(userInfo.checkPassword(username,userpassword)){
                response.addCookie(new Cookie("name",username));
                System.out.println("pass login");
                response.sendRedirect(request.getContextPath() + "/homepage");
            }else {
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                //out.print("<script language=\"javascript\">alert('密码或用户名错误！');window.location.href="+request.getContextPath()+"/loginForm</script>");
                response.sendRedirect(request.getContextPath() + "/loginForm");
            }
        }catch (DataAccessException e){
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/loginForm");
        }
//        if(result.hasErrors()){
//            System.out.println("has Errors");
//            response.sendRedirect(request.getContextPath() + "/loginForm");
//        }else {
//            if(userInfo.checkPassword(username,userpassword)){
//                response.addCookie(new Cookie("name",username));
//                System.out.println("pass login");
//                response.sendRedirect(request.getContextPath() + "/homepage");
//            }else {
//                System.out.println("not pass login");
//                response.sendRedirect(request.getContextPath() + "/loginForm");
//            }
//        }

    }

}
