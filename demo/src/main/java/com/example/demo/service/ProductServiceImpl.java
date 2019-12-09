package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByNameproduct(String nameproduct) {
        return productRepository.findByNameproduct(nameproduct);
    }

    @Override
    public Product findByMasp(Long masp) {
        return productRepository.findByMasp(masp);
    }

    @Override
    public void save(Product product) {
            productRepository.save(product);
    }

    @Override
    public void remove(Long masp) {
        productRepository.delete(masp);
    }
}
