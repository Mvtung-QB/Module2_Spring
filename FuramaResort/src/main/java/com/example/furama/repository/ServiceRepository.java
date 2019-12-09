package com.example.furama.repository;

import com.example.furama.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Integer> {
        Services findById(int id);
        List<Services> findAllByRentalCostsBetween(Integer s1, Integer s2);
}
