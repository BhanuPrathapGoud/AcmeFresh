package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerNotFound;
import com.masai.model.Customer;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao CustomersDao;

	@Override
	public List<Customer> getAllCustomerList() throws CustomerNotFound{
		List<Customer> list = CustomersDao.findAll();
		if(list.size() > 0) {
			return list;
		}else {
			throw new  CustomerNotFound("customers not exist");
		}
	}

	@Override
	public Customer getCustomerById(int id) throws CustomerNotFound{
		Optional<Customer> opt = CustomersDao.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new  CustomerNotFound("customer no exist with this"+id);
		}
	}

	@Override
	public String createCustomer(Customer Customers) throws CustomerNotFound {
		Optional<Customer> opt = CustomersDao.findById(Customers.getCustomer_id());
		if(opt.isPresent()) {
			throw new CustomerNotFound("This Customers Already Created");
		}else {
			CustomersDao.save(Customers);
			return "Customers Created Sucessfully";
		}
	}

	@Override
	public Customer deleteCustomerById(int id) throws CustomerNotFound {
		Optional<Customer> opt = CustomersDao.findById(id);
		if(!opt.isPresent()) {
			throw new  CustomerNotFound("customer no exist with this"+id);
		}else {
			Customer customers = opt.get();
			CustomersDao.delete(opt.get());
			return customers;
		}
	}

	@Override
	public Customer updateCustomerById(int id,Customer Customer) throws CustomerNotFound {
		Optional<Customer> opt = CustomersDao.findById(id);
		if(!opt.isPresent()) {
			throw new  CustomerNotFound("customer no exist with this"+id);
		}else {
			CustomersDao.save(Customer);			
			return Customer;
		}
	}

}
