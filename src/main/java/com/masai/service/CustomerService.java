package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerNotFound;
import com.masai.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomerList() throws CustomerNotFound;
	public Customer getCustomerById(int Id)throws CustomerNotFound;
	public String createCustomer(Customer Customer)throws CustomerNotFound;
	public Customer deleteCustomerById(int id)throws CustomerNotFound;
	public Customer updateCustomerById(int id, Customer Customer)throws CustomerNotFound;
}
