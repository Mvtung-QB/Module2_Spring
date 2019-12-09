package com.example.validate.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class User {
    @NotEmpty
    @Size(min = 5, max=45, message = "firt name size 5-45")
    private String firtName;
    @NotEmpty
    @Size(min = 5, max=45 , message = "last name size 5-45")
    private String lastName;
    @Pattern(regexp = ("^[0-9]{10}$"), message = "10 so")
    private String phoneNumber;
    @Range(min = 18, message = "min = 18")
    private int age;
    @Email(message = "email error")
    private String email;

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String firtName, String lastName, String phoneNumber, int age, String email) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }
}
