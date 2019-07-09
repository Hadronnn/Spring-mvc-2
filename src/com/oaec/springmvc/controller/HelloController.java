package com.oaec.springmvc.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
