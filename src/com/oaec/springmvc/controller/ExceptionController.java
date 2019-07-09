package com.oaec.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//处理异常的控制层
public class ExceptionController {
    @ExceptionHandler
    public ModelAndView exception(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/500");
        modelAndView.addObject("e",e);
        return modelAndView;
    }
}
