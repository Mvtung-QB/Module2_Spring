package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@SessionAttributes("listProduct")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("listProduct")
    public HashMap<Long, Cart> myList(){
        return new HashMap<>();
    }
    @GetMapping("/")
    public ModelAndView getProduct(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products" , productService.findAll());
        return modelAndView;
    }
    @GetMapping("/select/{masp}")
    public String buidList(@ModelAttribute("listProduct") HashMap<Long, Cart> cartItems, @PathVariable("masp") Long masp, Model model){
        Product product = productService.findByMasp(masp);
        if (product != null) {
            if (cartItems.containsKey(masp)) {
                Cart item = cartItems.get(masp);
                item.setProduct(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(masp, item);
            } else {
                Cart item = new Cart();
                item.setProduct(product);
                item.setQuantity(1);
                cartItems.put(masp, item);
            }
        }
        model.addAttribute("listProduct",cartItems);
        return "redirect:/";
    }
    @GetMapping("/delete/{masp}")
    public String updateList(@ModelAttribute("listProduct") HashMap<Long, Cart> cartItems,@PathVariable("masp") Long masp, Model model){
        for (Cart cart: cartItems.values() ) {
            if (cart.getProduct().getMasp().equals(masp)){
                cartItems.remove(masp);
                break;
            }
        }
        model.addAttribute("listProduct",cartItems);
        return "redirect:/";
    }
    @GetMapping("/{masp}")
    public ModelAndView viewProduct(@PathVariable("masp") Long masp) {
        ModelAndView modelAndView = new ModelAndView("view");
        Product product = productService.findByMasp(masp);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @GetMapping("/update/{masp}")
    public ModelAndView updateCart(@ModelAttribute("listProduct") HashMap<Long, Cart> cartItems,@PathVariable("masp") Long masp){
        ModelAndView modelAndView = new ModelAndView("update");
        Cart cart = cartItems.get(masp);
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
    @PostMapping("/save")
    public String saveCart(@ModelAttribute("listProduct") HashMap<Long, Cart> cartItems,@ModelAttribute("cart") Cart cart,@RequestParam("quantity") int quantity,Model model){
       cartItems.get(cart.getProduct().getMasp()).setQuantity(quantity);
       model.addAttribute("listProduct",cartItems);
        return "redirect:/";
    }
    @PostMapping("/total")
    public String totalPay(@ModelAttribute("listProduct") HashMap<Long, Cart> cartItems, Model model){
        Double total=0.0 ;
        for (Cart c: cartItems.values()) {
            total+= c.total();
        }
        model.addAttribute("products" , productService.findAll());
        model.addAttribute("total",total);
        return "index";
    }
}
