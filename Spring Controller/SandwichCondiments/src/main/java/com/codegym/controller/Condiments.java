package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class Condiments {
    @GetMapping("/")
    public String getForm() {
        return "form";
    }

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public String save(@RequestParam(name = "condiment",required = false) String[] condiment,
                       RedirectAttributes redirectAttributes,
                       Model model) {

        if(Objects.equals(condiment,null)){
            redirectAttributes.addFlashAttribute("mess", "Khong co");
            return "redirect:/";
        }else{
            model.addAttribute("condiment",condiment);
            redirectAttributes.addFlashAttribute("mess", "");
            return "success";
        }

    }
}
