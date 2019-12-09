package quanlytinh.quanly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import quanlytinh.quanly.entity.Customer;
import quanlytinh.quanly.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView getIndex( @PageableDefault(size = 3) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("/index");
        Iterable<Customer> customerList = customerService.findAll(pageable);
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }
    @PostMapping("/index")
    public ModelAndView findByName(@RequestParam("name") String name){
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Customer> customerList = customerService.findByName(name);
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }
}
