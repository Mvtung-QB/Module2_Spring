package controllers;

import model.Calculater;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculaterController {
    @GetMapping("/home")
    public String getHome(){
        return "home";
    }
    @PostMapping("/home")
    public String calculater(@RequestParam("operater") String operate, @RequestParam("num1") float num1,@RequestParam("num2") float num2, Model model){
       Calculater calculater = new Calculater(num1,num2);
       switch (operate){
           case "addition(+)":
               model.addAttribute("result", calculater.add());
               break;
           case "Subtraction(-)":
               model.addAttribute("result", calculater.sub());
               break;
           case "divition(/)":
               model.addAttribute("result", calculater.div());
               break;
           case "Multiplication(X)":
               model.addAttribute("result", calculater.mul());
               break;

       }
       return "home";
    }
}
