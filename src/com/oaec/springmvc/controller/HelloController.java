package com.oaec.springmvc.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class HelloController {
    @RequestMapping("/test1")
    public String test1(Integer num, Model model){
//        try {
            int result = 10 / num;
            model.addAttribute("result",result);
            return "hello";
//        }catch (Exception e){
//            model.addAttribute("e",e);
//            return "error/500";
//        }
    }
    @RequestMapping("/test2")
    public String test2(String name,Model model){
        int length = name.length();
        model.addAttribute("result",length);
        return "hello";
    }
    @RequestMapping("/testDate")
    //testDate?date=2019-07-09 11:15:00
    public String testDate(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, Model model){
        model.addAttribute("result",date);
        return "hello";
    }
    @RequestMapping("/testNumber")
    //testNumber?price=4,321,234.99
    public String testNumber(@NumberFormat(pattern = "#,###,###.##") Double price, Model model){
        model.addAttribute("result",price);
        return "hello";
    }
    @RequestMapping("/test")
    public String test(){
        System.out.println("HelloController.test");
        return "hello";
    }
    @RequestMapping("/login")
    public String login(){
        System.out.println("HelloController.login");
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(HttpServletRequest request,HttpSession session, String username, String password,String uri){
        System.out.println("HelloController.doLogin");
        if ("tom".equals(username) && "123456".equals(password)){
            session.setAttribute("username",username);
            if (uri != null){
                String contextPath = request.getContextPath();
                System.out.println("uri = " + uri);
                uri = uri.replace(contextPath,"");
                System.out.println("uri = " + uri);
                return "redirect:"+uri;
            }else{
                return "redirect:/index";
            }
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }
    @RequestMapping("/order")
    public String order(){
        return "order";
    }
    @RequestMapping("/product")
    public String product(){
        return "product";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("username");
        return "index";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    //统一异常处理
    /*@ExceptionHandler({NullPointerException.class})
    public ModelAndView exception1(Exception e){
        System.out.println("HelloController.exception1");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/500");
        modelAndView.addObject("e",e);
        return modelAndView;
    }
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView exception2(Exception e){
        System.out.println("HelloController.exception2");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/500");
        modelAndView.addObject("e",e);
        return modelAndView;
    }*/
}
