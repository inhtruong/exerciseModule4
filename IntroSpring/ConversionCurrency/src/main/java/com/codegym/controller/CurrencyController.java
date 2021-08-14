package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {
    @GetMapping ("form")
    public ModelAndView getFormConvert() {
        ModelAndView modelAndView = new ModelAndView("formconvert");
        return modelAndView;
    }

    @PostMapping("result")
    public ModelAndView calculatorCurrency(@RequestParam("amount") String amount) {
        ModelAndView modelAndView = new ModelAndView("success");
        int result = Integer.parseInt(amount) * 23000;
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
