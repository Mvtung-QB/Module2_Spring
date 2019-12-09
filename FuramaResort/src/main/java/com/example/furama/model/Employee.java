package com.example.furama.model;

public class Employee {
    private String nameEmployee;
    private int ageEmployee;
    private String address;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee() {
    }

    public Employee(int id, String nameEmployee, int ageEmployee, String address) {
        this.id = id;
        this.nameEmployee = nameEmployee;
        this.ageEmployee = ageEmployee;
        this.address = address;
    }

    @Override
    public String toString() {
        return " ID: " +this.getId()+
                " Name: " +this.getNameEmployee()+
                " Age: " +this.getAgeEmployee()+
                " Address: "+ this.getAddress();
    }
}
