package com.example.validate.controller;

import com.example.validate.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FormController {
    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("user")User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        else {
            model.addAttribute("user", user);
            return "result";
        }
    }
}
