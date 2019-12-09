package controllers;

import model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String getHome(){
        return "home";
    }
    @PostMapping(value = "/home")
    public ModelAndView getCondiment(@ModelAttribute("Condiment") String condiment){
        Sandwich sandwich = new Sandwich();
        sandwich.setCondiment(condiment);
        ModelAndView modelAndView = new ModelAndView("showMenu","sandwich",sandwich);
       return  modelAndView;
    }

}
