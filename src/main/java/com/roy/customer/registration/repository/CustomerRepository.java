package com.roy.customer.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roy.customer.registration.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
