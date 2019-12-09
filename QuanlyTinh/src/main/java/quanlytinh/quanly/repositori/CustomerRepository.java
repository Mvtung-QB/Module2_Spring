package quanlytinh.quanly.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import quanlytinh.quanly.entity.Customer;

import java.util.List;

public interface CustomerRepository<list> extends JpaRepository<Customer,Long> {

    List<Customer> findByName(String name);
}
