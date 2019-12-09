package com.example.furama.repository;

import com.example.furama.model.Customer;
import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
