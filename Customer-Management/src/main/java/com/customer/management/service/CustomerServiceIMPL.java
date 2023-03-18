package com.customer.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.management.entity.Customer;
import com.customer.management.repository.CustomerRepository;
import com.customer.management.exception.CustomerAlreadyExists;
import com.customer.management.exception.NoExistingCustomer;

@Service
public class CustomerServiceIMPL implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		
		return customerRepo.findAll();
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		Customer cus=customerRepo.findById(id).orElse(null);
		
		if (cus==null)
		{
			throw new NoExistingCustomer("No existing customer by this id");
		}
		else {
		return customerRepo.findById(id).orElse(null);
		}
	}

	@Override
	public String saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer cus=customerRepo.findById(customer.getId()).orElse(null);
		
		if(cus==null)
		{
			customerRepo.save(customer);
			return "Customer Added successfully";
		}
		else {
			 throw new CustomerAlreadyExists("Customer is already exists");
		}
		 
		 
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		// TODO Auto-generated method stub
		
		Customer fake=customerRepo.findById(customer.getId()).orElse(null);
		
		if(fake==null)
		{
			throw new NoExistingCustomer("No existing Customer with this ID");
		}
		else {
			fake.setEmail(customer.getEmail());
			fake.setDateOfBirth(customer.getDateOfBirth());
			fake.setFirstname(customer.getFirstname());
			fake.setLastname(customer.getLastname());
			fake.setJoindate(customer.getJoindate());
			return customerRepo.save(fake);
		}
				
	}

	@Override
	public String deleteCustomerById(int id) {
		
		// TODO Auto-generated method stub
		
		Customer cus=customerRepo.findById(id).orElse(null);
		
		if(cus  == null)
		{
			throw new NoExistingCustomer("No existing Customer with this ID");
		}
		else {
		customerRepo.deleteById(id);
		return "Customer successfully deleted";
	}
	}

	public Customer findCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		Customer cus= customerRepo.getCustomerByEmail(email);
		if(cus==null)
		{
			throw new NoExistingCustomer("No existing customer with this email");
		}
		else {
		
		  return customerRepo.getCustomerByEmail(email);
		}
	}

}
