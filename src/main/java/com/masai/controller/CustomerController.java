package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerNotFound;
import com.masai.model.Customer;
import com.masai.service.CustomerService;
@RestController
public class CustomerController {
	@Autowired
	CustomerService CustomerService;
	@PostMapping("/Customers")
	public ResponseEntity<String>   createCustomer(@RequestBody Customer Customer) throws CustomerNotFound {
		String status =  CustomerService.createCustomer(Customer);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	@GetMapping("/Customers")
	public ResponseEntity<List<Customer>> getAllCustomerList() throws CustomerNotFound{
		return new ResponseEntity<>(CustomerService.getAllCustomerList(),HttpStatus.ACCEPTED);
	}
	@GetMapping("/Customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) throws CustomerNotFound {
		return new ResponseEntity<Customer>(CustomerService.getCustomerById(id),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/Customers/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int id) throws CustomerNotFound {
		return new ResponseEntity<Customer>(CustomerService.deleteCustomerById(id),HttpStatus.ACCEPTED);
	}
	@PatchMapping("/Customers/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable int id,@RequestBody Customer Customer) throws CustomerNotFound {
		return new ResponseEntity<Customer>(CustomerService.updateCustomerById(id,Customer),HttpStatus.CREATED);
	}
}
