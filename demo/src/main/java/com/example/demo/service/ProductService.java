package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService  {
    List<Product> findAll();

    List<Product> findByNameproduct(String nameproduct);

    Product findByMasp(Long masp);

    void save(Product product);

    void remove(Long masp);
}
