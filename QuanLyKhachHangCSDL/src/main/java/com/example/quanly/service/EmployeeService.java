package com.example.quanly.service;

import com.example.quanly.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    void save(Employee customer);

    void remove(Long id);
    List<Employee> findAllEmployeeByDiaChi (String diaChi);
    List<Employee> findEmployeeByName (String name);
    List<Employee> findEmployeeByNameLike (String name);
}
