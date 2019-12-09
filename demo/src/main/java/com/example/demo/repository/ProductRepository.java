package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository<List> extends JpaRepository<Product,Long> {

    java.util.List<Product> findByNameproduct(String nameProduct);
    Product findByMasp(Long masp);
}
