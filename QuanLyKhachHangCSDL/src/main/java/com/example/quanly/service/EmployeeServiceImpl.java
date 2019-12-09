package com.example.quanly.service;

import com.example.quanly.entity.Employee;
import com.example.quanly.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee customer) {
        employeeRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.remove(id);
    }

    @Override
    public List<Employee> findAllEmployeeByDiaChi(String diachi) {
        return employeeRepository.findAllEmployeeByDiaChi(diachi);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
      return employeeRepository.findEmployeeByName(name);
    }

    @Override
    public List<Employee> findEmployeeByNameLike(String name) {
//        return repository.findByNameLike(name);
        return null;
    }
}