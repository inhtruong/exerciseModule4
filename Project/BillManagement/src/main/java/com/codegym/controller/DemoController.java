package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("/WEB-INF/views/home.html");
//        modelAndView.addObject("value", "Hello World");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping()
    public String getPage() {
        return "Page";
    }
}
