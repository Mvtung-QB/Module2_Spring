package com.example.furama.model;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Component
@Entity
@Table(name = "tblkhachhang")
public class Customer implements Validator {
    @Id
    @Column(name = "idkhachhang")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = "^([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Bắt dầu Là  Kí tự in hoa")
    @Column(name = "hoten")
    private String nameCustumer;

    @Column(name = "ngaysinh")
    private String birtherday;

    @Pattern(regexp = "^[0-9]{9}$",message = "9 chữ số")
    @Column(name = "socmnd")
    private String  idCard;

    @Pattern(regexp = "^[0-9]{9}$",message = "9 chữ số")
    @Column(name = "sodienthoai")
    private String phoneNumber;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Ex: Tung123@gmail.com")
    @Column(name = "email")
    private String email;


    @Column(name = "diachi")
    private String address;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustumer() {
        return nameCustumer;
    }

    public void setNameCustumer(String nameCustumer) {
        this.nameCustumer = nameCustumer;
    }

    public String getBirtherday() {
        return birtherday;
    }

    public void setBirtherday(String birtherday) {
        this.birtherday = birtherday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Customer(int id,String nameCustumer, String birtherday, String idCard, String phoneNumber, String email, String address) {
        this.id = id;
        this.nameCustumer = nameCustumer;
        this.birtherday = birtherday;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Customer() {
    }

    public String showInformation() {
        return "Name Custumer " + this.getNameCustumer() +
                " Birthday " + this.getBirtherday() +
                " ID Card " + this.getIdCard() +
                " Phone Number " + this.getPhoneNumber() +
                " Email " + this.getEmail() +
                " Address " + this.getAddress();
    }
    public String showIDName(){
        return "Name Custumer " + this.getNameCustumer() +
                " ID Card " + this.getIdCard();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom((aClass));
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer = (Customer) o;
        String birtherday = customer.getBirtherday();

        if (birtherday==""){
            errors.rejectValue("birtherday", "birtherday.empty");
        }else {
            String birthdayArr[] = birtherday.split("-");
            int year = Integer.parseInt(birthdayArr[0]);
            if (year < 1970 || year> 2001){
                errors.rejectValue("birtherday", "birtherday.ivalid");
            }
        }
    }
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("ValidationMessages");
        return messageSource;
    }
}
