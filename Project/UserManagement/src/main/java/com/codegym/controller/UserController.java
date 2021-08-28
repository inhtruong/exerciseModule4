package com.codegym.controller;

import com.codegym.DTO.TransferDTO;
import com.codegym.model.Transfer;
import com.codegym.model.User;
import com.codegym.service.ITransferService;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ITransferService transferService;

    @GetMapping("")
    public ModelAndView getIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        List<User> userList = userService.findAll();
        modelAndView.addObject("users", userList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(Model model) {
        return new ModelAndView("create","user", new User());
    }

    @PostMapping("/save-insert")
    public ModelAndView save(User user, RedirectAttributes redirectAttributes) {
        userService.insert(user);
        redirectAttributes.addFlashAttribute("success", "Add success");
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id, Model model) {
        return new ModelAndView("edit","user", userService.findOne(id));
    }
//
    @PostMapping("/update")
    public ModelAndView update(User user, RedirectAttributes redirectAttributes) {
        userService.update(user);
        redirectAttributes.addFlashAttribute("success", "Edit success");
        return new ModelAndView("redirect:/user");
    }
//
    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        return new ModelAndView("deleter","user", userService.findOne(id));
    }

    @PostMapping("/save-delete")
    public ModelAndView delete(User user, RedirectAttributes redirect) {
        userService.remove(user.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable int id, Model model) {
        return new ModelAndView("view","user", userService.findOne(id));
    }

    @GetMapping("/{id}/deposit")
    public ModelAndView deposit(@PathVariable int id, Model model) {
        return new ModelAndView("deposit","user", userService.findOne(id));
    }

    @PostMapping("/save-deposit")
    public ModelAndView deposit(User user, @RequestParam("deposit") float deposit, RedirectAttributes redirect) {
        userService.deposit(user.getId(), deposit);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/{id}/withdraw")
    public ModelAndView withdraw(@PathVariable int id, Model model) {
        return new ModelAndView("withdraw","user", userService.findOne(id));
    }

    @PostMapping("/save-withdraw")
    public ModelAndView withdraw(User user, @RequestParam("withdraw") float withdraw, RedirectAttributes redirect) {
        userService.withdraw(user.getId(), withdraw);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/{id}/transfer")
    public ModelAndView transfer(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("transfer");
        modelAndView.addObject("transfer", new Transfer());
        modelAndView.addObject("userSender", userService.findOne(id));
        modelAndView.addObject("listUser", userService.findAllExceptId(id));
        return modelAndView;

    }

    @PostMapping("/save-transfer")
    public ModelAndView transfer(Transfer transfer, RedirectAttributes redirect) {
        transferService.insert(transfer);
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return new ModelAndView("redirect:/user");
    }
}
