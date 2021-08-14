package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public ModelAndView getDictionary() {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        return modelAndView;
    }

    @PostMapping("/result")
    public ModelAndView getResult(@RequestParam("word") String word) {
        ModelAndView modelAndView = new ModelAndView("success");
        String result = searchWord(word);
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    private String searchWord(String word) {
        String result = "";
        Map<String, String> dic = new HashMap<String, String>();
        dic.put("computer","máy tính");
        dic.put("smartphone","điện thoại thông minh");
        dic.put("book","sách");
        dic.put("pen","bút viết");

        if(dic.containsKey(word)) {
            result = dic.get(word);
        } else {
            result = "Từ nay hiện tại không có trong từ điển";
        }
        return result;
    }
}

