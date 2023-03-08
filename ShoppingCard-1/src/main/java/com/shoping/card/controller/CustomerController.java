package com.shoping.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shoping.card.entity.Customer;
import com.shoping.card.pojo.CustomerPojo;
import com.shoping.card.service.CustomerService;


@RestController
//@RequestMapping("/api/users")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@PostMapping(value = "/createCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCustomer(@RequestBody CustomerPojo customer)	{
		return service.createCustomer(customer);
	}
	
	@PutMapping(value="/updateCustomer/{customerId}")
	public Customer updateCustomerDetails(@PathVariable String customerId,@RequestBody Customer customer) {
		return service.updateCustomerDetails(customerId,customer);
	}

	@GetMapping(value= "/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> customers =  service.getAllCustomer();
		if(customers != null && customers.size() > 0){
			return new ResponseEntity<>(customers, HttpStatus.OK);
		}
		else
			return new ResponseEntity("No record found", HttpStatus.OK);
	}

	
	@GetMapping(value="/getCustomerById/{customerId}")
	public CustomerPojo getCustomerById(@PathVariable String customerId) {
		return service.getCustomerById(customerId);
	}
	
	@GetMapping(value="/getAllCustomerByName/{name}")
	public List<CustomerPojo> getAllCustomerByName(@PathVariable String name){
		return service.getCustomerByName(name);
	}

	@DeleteMapping(value="/deleteCustomer/{customerId}")
	public String deleteCustomer(@PathVariable String customerId) {
		return service.deleteCustomer(customerId);
	}
}
