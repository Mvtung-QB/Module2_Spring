package quanlytinh.quanly.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quanlytinh.quanly.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService  {
    Page<Customer> findAll(Pageable  pageable);

    List<Customer> findByName(String name);

    Optional findById(Long id);

    void save(Customer province);

    void remove(Long id);
}
