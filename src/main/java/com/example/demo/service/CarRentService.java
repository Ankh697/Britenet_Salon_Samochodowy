package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.CarRent;
import com.example.demo.domain.Customer;

import java.util.List;
import java.util.Optional;



public interface CarRentService {
    // -------------- CAR METHODS ----------------------
    void addCars(Car... cars);
    List<Car> getAllCars();
    List<Car> findByCarModel(String model);
    Optional<Car> modifyCar(Car car);
    Optional<Car> removeCar(Long id);

    // -------------- CUSTOMER METHODS -----------------
    void addCustomers(Customer ... customers);
    List<Customer> getAllCustomers();
    List<Customer> finByCustomerName(String name);
    List<Customer> findByCustomerSurname(String surname);
    List<Customer> findBYCustomerNameAndSurname(String name, String surname);
    List<Customer> findByCustomerId(Long id);
    Optional<Customer> removeCustomer(Long id);
    Optional<Customer> modifyCustomer(Customer customer);


    // -------------- CAR RENT METHODS -----------------
    /*void addCarRents(CarRent ... carRents);
    Optional<CarRent> modifyCarRent(CarRent carRent);
    Optional<CarRent> removeCarRent(CarRent carRent);
    List<CarRent> getAllCarRents();*/
}
