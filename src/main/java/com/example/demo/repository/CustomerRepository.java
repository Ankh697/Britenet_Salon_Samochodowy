package com.example.demo.repository;

import com.example.demo.domain.Car;
import com.example.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByName(String name);
    List<Customer> findCustomerBySurname(String surname);
    List<Customer> findCustomerByNameAndSurname(String name, String surname);
    List<Customer> findCustomerByID(Long id);
}
