package validation.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import validation.validation.model.User;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }
}
