package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.example.demo.domain.Customer;
import com.example.demo.service.CarRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class MyRestController {

    private CarRentService wypozyczalniaService;

    @Autowired
    public MyRestController(CarRentService wypozyczalniaService) {
        this.wypozyczalniaService = wypozyczalniaService;
    }

    @RequestMapping("/insert/")
    public String insertMethod()
    {
        /*Car c1 = new Car("BMW");
        Car c2 = new Car("AUDI");
        Car c3 = new Car("MERCEDES");

        Customer cc1 = new Customer("Jan", "Kowalski");
        Customer cc2 = new Customer("Adam", "Nowak");
        Customer cc3 = new Customer("Kamil", "Popek");
        Customer cc4 = new Customer("Grzegorz", "Kluska");
        Customer cc5 = new Customer("Iza", "Kalisz");

        CarRent cr1 = new CarRent(new BigDecimal("100"));
        cr1.setCar(c1);
        cr1.setCustomer(cc1);

        CarRent cr2 = new CarRent(new BigDecimal("200"));
        cr2.setCar(c2);
        cr2.setCustomer(cc2);

        CarRent cr3 = new CarRent(new BigDecimal("300"));
        cr3.setCar(c3);
        cr3.setCustomer(cc3);

        carRentRepository.save(cr1);
        carRentRepository.save(cr2);
        carRentRepository.save(cr3);*/

        return "OK";
    }

    @RequestMapping(value = "/cars/select/all", method = RequestMethod.GET)
    public List<Car> carsSelectAllMethod()
    {
        return wypozyczalniaService.getAllCars();
    }

    @RequestMapping(value = "cars/select/one", method = RequestMethod.POST)
    public List<Car> carsSelectOneByModel(@RequestBody String model)
    {
        List<Car> cars = wypozyczalniaService.findByCarModel(model);
        return cars;
    }

    /*
        {
            "model": "PORSCHE"
        }
     */
    @RequestMapping(value = "cars/insert", method = RequestMethod.POST)
    public Car carsInsert(@RequestBody Car car )
    {
        if (car != null)
        {
            wypozyczalniaService.addCars(car);
        }
        return car;
    }

    /*
        {
            "id": 5,
            "model": "LADA"
        }
     */
    @RequestMapping(value = "cars/update", method = RequestMethod.PUT)
    public Car carsUpdate(@RequestBody Car car )
    {
        if (car != null)
        {
            wypozyczalniaService.modifyCar(car);
        }
        return car;
    }

    //wpisujesz po prostu 5 lub inne id
    @RequestMapping(value = "cars/delete", method = RequestMethod.DELETE)
    public Car carsDelete(@RequestBody Long id)
    {
        return wypozyczalniaService.removeCar(id).get();
    }

    @RequestMapping(value = "customers/select/all", method = RequestMethod.GET)
    public List<Customer> customersSelectAll()
    {
        return wypozyczalniaService.getAllCustomers();
    }

    @RequestMapping(value = "/customer/select/all", method = RequestMethod.GET)
    public List<Customer> customerSelectAllMethod()
    {
        return wypozyczalniaService.getAllCustomers();
    }

    @RequestMapping(value = "customer/select/oneById", method = RequestMethod.POST)
    public List<Customer> customerSelectOneById(@RequestBody Long id)
    {
        List<Customer> customers = wypozyczalniaService.findByCustomerId(id);
        return customers;
    }

    @RequestMapping(value = "customer/delete", method = RequestMethod.DELETE)
    public Customer customerDelete(@RequestBody Long id)
    {
        return wypozyczalniaService.removeCustomer(id).get();
    }

    @RequestMapping(value = "customer/insert", method = RequestMethod.POST)
    public Customer customerInsert(@RequestBody Customer customer)
    {
        if (customer!= null)
        {
            wypozyczalniaService.addCustomers(customer);
        }
        return customer;
    }
    @RequestMapping(value = "customer/update", method = RequestMethod.PUT)
    public Customer customerUpdate(@RequestBody Customer customer)
    {
        if (customer != null)
        {
            wypozyczalniaService.modifyCustomer(customer);
        }
        return customer;
    }



}
