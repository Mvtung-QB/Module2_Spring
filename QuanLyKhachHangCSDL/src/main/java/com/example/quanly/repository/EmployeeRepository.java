package com.example.quanly.repository;

import com.example.quanly.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee> {
    List<Employee> findAllEmployeeByDiaChi(String diachi);

    List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeeByNameLike(String name);
}
