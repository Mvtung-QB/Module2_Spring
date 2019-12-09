package com.example.furama.service;

import com.example.furama.model.Customer;
import com.example.furama.model.Services;

import java.util.List;

public interface SVService {
    List<Services> findAll();
    Services findById(int id);
    List<Services> findAllByRentalCostsBetween(Integer s1, Integer s2);
}
