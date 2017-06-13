package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.Customer;
import com.example.demo.repository.CarRentRepository;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class CarRentServiceImpl implements CarRentService {
    private CarRepository carRepository;
    private CustomerRepository customerRepository;
    private CarRentRepository carRentRepository;

    @Autowired
    public CarRentServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, CarRentRepository carRentRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.carRentRepository = carRentRepository;
    }

    @Transactional
    @Override
    public void addCars(Car... cars) {
        for (Car c : cars)
        {
            carRepository.save(c);
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findByCarModel(String model) {

        return carRepository.findCarByModel(model);
    }

    @Override
    public Optional<Car> modifyCar(Car car) {
        Car carFromDb = carRepository.findOne(car.getId());
        carFromDb.setModel(car.getModel());
        carFromDb.setCarRents(car.selectAllCarRents());
        carRepository.save(carFromDb);
        return Optional.ofNullable(carFromDb);
    }

    @Override
    public Optional<Car> removeCar(Long id) {
        Car car = carRepository.findOne(id);
        carRepository.delete(id);
        return Optional.ofNullable(car);
    }
//===========================CUSTOMER============================
    @Override
    public void addCustomers(Customer... customers) {
        for(Customer c : customers)
        {
            customerRepository.save(c);
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> finByCustomerName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    public List<Customer> findByCustomerSurname(String surname) {
        return customerRepository.findCustomerBySurname(surname);
    }

    @Override
    public List<Customer> findBYCustomerNameAndSurname(String name, String surname) {
        return customerRepository.findCustomerByNameAndSurname(name, surname);
    }

    @Override
    public List<Customer> findByCustomerId(Long id) {
        return customerRepository.findCustomerByID(id);
    }

    @Override
    public Optional<Customer> removeCustomer(Long id) {
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(id);
        return Optional.ofNullable(customer);
    }

    @Override
    public Optional<Customer> modifyCustomer(Customer customer) {
        Customer customerFromDb = customerRepository.findOne(customer.getId());
        customerFromDb.setId(customer.getId());
        customerFromDb.setName(customer.getName());
        customerFromDb.setSurname(customer.getSurname());
        customerFromDb.setCarRents(customer.selectAllCustomerRents());
        customerRepository.save(customerFromDb);
        return Optional.ofNullable(customerFromDb);
    }




}
