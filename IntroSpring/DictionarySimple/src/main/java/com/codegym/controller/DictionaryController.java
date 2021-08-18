package com.codegym.controller;

import com.codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public ModelAndView getDictionary() {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        return modelAndView;
    }

    @PostMapping("/result")
    public ModelAndView getResult(@RequestParam("word") String word) {
        ModelAndView modelAndView = new ModelAndView("success");
        String result = dictionaryService.searchWord(word);
        modelAndView.addObject("result", result);
        return modelAndView;
    }


}

