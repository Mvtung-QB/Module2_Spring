package com.example.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String gtoLogin(){
        return "login";
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
        ModelAndView modelAndView =  new ModelAndView("/");
        System.out.println(username   + password);
        return modelAndView;
    }
}
