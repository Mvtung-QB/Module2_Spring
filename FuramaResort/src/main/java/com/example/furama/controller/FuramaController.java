package com.example.furama.controller;

import com.example.furama.model.Customer;
import com.example.furama.model.HopDong;
import com.example.furama.model.SeerviceDeque;
import com.example.furama.model.Services;
import com.example.furama.repository.CustomerRepository;
import com.example.furama.repository.HopDongRepository;
import com.example.furama.repository.ServiceRepository;
import com.example.furama.service.CustomerService;
import com.example.furama.service.HopDongService;
import com.example.furama.service.SVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.xml.ws.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("likeservice")
public class FuramaController {
    @Autowired
    SVService svService;
    @Autowired
    CustomerService customerService;
    @Autowired
    HopDongService hopDongService;

    @ModelAttribute("likeservice")
    public SeerviceDeque likeserviceList(){
        return new SeerviceDeque();
    }

    @GetMapping("like/{id}")
    public String like(@PathVariable("id") int id, @ModelAttribute("likeservice") SeerviceDeque likeserviceList){
        likeserviceList.add(svService.findById(id));
        return "redirect:/";
    }
    @GetMapping("dislike/{id}")
    public String disLike(@PathVariable("id") int id, @ModelAttribute("likeservice") SeerviceDeque likeserviceList){
        for (Services s: likeserviceList
             ) {if (s.getId()==id){
                 likeserviceList.remove(s);
            }
        }
        return "redirect:/likepage";
    }
    @GetMapping("/likepage")
    public String getLikePage(){
        return "like";
    }

    @ModelAttribute("listServiceHasBooking")
    public ArrayList<HopDong> listServiceHasBooking(){
        return new ArrayList<>();
    }
        @GetMapping("/")
        public ModelAndView getIndex(){
            List<Services> listService = svService.findAll();
            ModelAndView modelAndView =  new ModelAndView("index");
            modelAndView.addObject("listService",listService);
            return modelAndView;
        }
        @GetMapping("/{id}")
        public ModelAndView getInforService(@PathVariable("id") int id){
            Services myService = svService.findById(id);
            ModelAndView modelAndView =  new ModelAndView("view");
            modelAndView.addObject("myService",myService);
            return modelAndView;
        }
        @PostMapping("/find")
        public ModelAndView listService( @RequestParam("rentalCosts1") Integer rentalCosts1,@RequestParam("rentalCosts1") Integer rentalCosts2 ){
            ModelAndView modelAndView =  new ModelAndView("find");
            List<Services> servicesList;
            if(rentalCosts1 == null || rentalCosts2== null){
                servicesList = svService.findAll();
            }else {
                servicesList = svService.findAllByRentalCostsBetween(rentalCosts1, rentalCosts2);
            }
            modelAndView.addObject("listService",servicesList);
            return modelAndView;
        }
        @GetMapping("/find")
        public String getFindPage(){
            return "/find";
        }

        @GetMapping("/booking")
        public ModelAndView getBookingPage( @CookieValue(value = "listBooking", defaultValue = "defaul") String listbooking){
            System.out.println(listbooking.toString());
            ModelAndView modelAndView =  new ModelAndView("booking");
            List<Services> list = svService.findAll();
            modelAndView.addObject("list",list);
            modelAndView.addObject("hopdong",new HopDong());
            return  modelAndView;
        }
        @PostMapping("/booking")
        public ModelAndView bookingService(@Valid @ModelAttribute("hopdong") HopDong hopDong, HttpServletResponse response, BindingResult bindingResult){
            ModelAndView modelAndView = new ModelAndView("booking");
            // validate view
            if (bindingResult.hasFieldErrors()) {
                List<Services> list = svService.findAll();
                modelAndView.addObject("list",list);
                return modelAndView;
            }
            // validate controller
            try {
                hopDongService.save(hopDong);
                int idKhach = hopDong.getIdKhachHang();
                // create cookie and set it in response
               Iterable<HopDong> listBooking = hopDongService.findAllByIdKhachHang(idKhach);
                for (HopDong h: listBooking) {
                    Cookie cookie = new Cookie("hd"+h.getIdHopDong(),hopDong.toString());
                    cookie.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookie);
                }
                    //get all cookies
                    // Cookie[] cookies = request.getCookies();
                    modelAndView.addObject("messger", "succes");
            }catch (Exception e) {
                modelAndView.addObject("messger", e);
            }
            return modelAndView;
        }


    @GetMapping("/historycart")
    public ModelAndView getCart(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("historycart");
        Cookie[] cookies = request.getCookies();
        ArrayList<HopDong> listBooking = new ArrayList<>();
        for (Cookie c: cookies) {
            if (c.getName().contains("hd")){
                HopDong  hopDong = new HopDong();
                String hd[]= c.getValue().split("\\_");
                hopDong.setIdHopDong(Integer.parseInt(hd[0]));
                hopDong.setIdKhachHang(Integer.parseInt(hd[1]));
                hopDong.setNgayLamHopDong(Date.valueOf(hd[2]));
                hopDong.setNgayketThuc(Date.valueOf(hd[3]));
                hopDong.setTienDatCoc(Double.parseDouble(hd[4]));
                int idDichVu = Integer.parseInt(hd[5]);
                hopDong.setId(svService.findById(idDichVu));
                listBooking.add(hopDong);
            }
            modelAndView.addObject("listBooking",listBooking);
        }
        return  modelAndView;
    }
    @GetMapping("/registered")
    public ModelAndView getRegisterPage() {
        ModelAndView modelAndView = new ModelAndView("registered");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("/registered")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("registered");
        // validate view
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return modelAndView;
        }
        // validate controller
        try {
            customerService.save(customer);
            modelAndView.addObject("messger","succes");
        }catch (Exception e) {
            modelAndView.addObject("messger", e);
        }
        return modelAndView;
    }

}
