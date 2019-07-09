package com.oaec.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    public String testException(Integer num, Model model){
        try {
            int result = 10 / num;
            model.addAttribute("result",result);
            return "hello";
        }catch (Exception e){
            model.addAttribute("e",e);
            return "error/500";
        }
    }

}
