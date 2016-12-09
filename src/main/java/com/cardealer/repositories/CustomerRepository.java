package com.cardealer.repositories;

import com.cardealer.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
//Get all customers ordered by their birth date ascending.
// If two customers are born on the same date first print those who are not young drivers

    @Query(value = "SELECT c FROM Customer AS c " +
            "order by c.birthDate ASC, c.isYoungDriver ASC ")
    List<Customer> findAllOrderByNameASCBirthDateASC();
}