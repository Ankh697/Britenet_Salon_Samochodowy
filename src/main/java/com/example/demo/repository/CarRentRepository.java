package com.example.demo.repository;

import com.example.demo.domain.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentRepository extends JpaRepository<CarRent, Long> {
    //zwraca wszystkie wypozyczenia dla samochodow ktore maja model podany jako
    //argument oraz name podany jako argument
    List<CarRent> findAllByCar_ModelAndCustomer_Name(String model, String name);

}
