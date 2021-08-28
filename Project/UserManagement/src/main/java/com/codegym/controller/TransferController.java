package com.codegym.controller;

import com.codegym.service.ITransferDTOService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("transfer")
public class TransferController {
    @Autowired
    private ITransferDTOService transferDTOService;

    @GetMapping("/history")
    public ModelAndView getHistory() {
        ModelAndView modelAndView = new ModelAndView("transfer-history",
                "listTransfer", transferDTOService.findAll());
        return modelAndView;
    }
}
