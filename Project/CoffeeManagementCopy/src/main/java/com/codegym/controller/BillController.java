package com.codegym.controller;

import com.codegym.model.Bill;
import com.codegym.service.IBillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private IBillService billService;

    @GetMapping("")
    public ModelAndView getIndex(ModelAndView modelAndView) {
        List<Bill> billList = billService.findAll();

        modelAndView.setViewName("home");
        modelAndView.addObject("bills", billList);
        return modelAndView;
    }

    @GetMapping("/bills/view/{id}")
    public ModelAndView getView(@PathVariable long id, ModelAndView modelAndView) {
        modelAndView.setViewName("view");
        modelAndView.addObject("bill", billService.findOne(id));
        return modelAndView;
    }
}
