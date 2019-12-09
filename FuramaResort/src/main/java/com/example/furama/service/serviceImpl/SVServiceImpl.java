package com.example.furama.service.serviceImpl;

import com.example.furama.model.Services;
import com.example.furama.repository.ServiceRepository;
import com.example.furama.service.SVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SVServiceImpl implements SVService {
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Services findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Services> findAllByRentalCostsBetween(Integer s1, Integer s2){
        return serviceRepository.findAllByRentalCostsBetween(s1,s2);
    }

}
