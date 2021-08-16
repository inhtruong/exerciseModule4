package com.codegym.controller;

import com.codegym.service.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {

    @Autowired
    private Validate validate;

    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/validate")
    public String user(@RequestParam("email") String email, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        boolean isValid = validate.validate(email);
        if (!isValid) {
            redirectAttributes.addFlashAttribute("message", "Email is invalid");

//            modelMap.addAttribute("message", "Email is invalid");
            return "redirect:/";
        }
        modelMap.addAttribute("email", email);
        return "success";
    }


}
