package com.example.furama.service.serviceImpl;

import com.example.furama.model.Customer;
import com.example.furama.repository.CustomerRepository;
import com.example.furama.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

}
