package com.roy.customer.registration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roy.customer.registration.model.Customer;
import com.roy.customer.registration.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping(value = "/listCustomers", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = service.getAllCustomers();
		if (customers == null) {
			customers = new ArrayList<>();
			return new ResponseEntity<List<Customer>>(customers, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@PostMapping(value = "/saveCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> saveCustomer(RequestEntity<Customer> requestEntity) {

		Customer customer = requestEntity.getBody();

		if (customer == null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.NO_CONTENT);
		} else {
			service.save(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		}
	}

	@PatchMapping(value = "/update/{id}")
	public ResponseEntity<Object> updateCustomer(@PathVariable("id") String id, RequestEntity<Customer> requestEntity) {
		service.save(requestEntity.getBody());
		return new ResponseEntity<>("Customer is updated successsfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		service.deleteCustomer(id);
		return new ResponseEntity<>("Customer is deleted successsfully", HttpStatus.OK);
	}
}
