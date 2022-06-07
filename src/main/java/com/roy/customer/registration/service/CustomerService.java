package com.roy.customer.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roy.customer.registration.model.Customer;
import com.roy.customer.registration.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	public Customer getCustomer(int id) {
		return repo.findById(id).get();
	}

	public void save(Customer customer) {
		if ((customer != null)) {
			repo.save(customer);
		}
	}

	public void deleteCustomer(int id) {
		Customer customer = getCustomer(id);
		if (customer != null) {
			repo.deleteById(id);
		}
	}

}
