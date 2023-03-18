package com.customer.management.service;

import java.util.List;

import com.customer.management.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getAllCustomers();
	public Customer findCustomerById(int id);
	public String saveCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public String deleteCustomerById(int id);
	public Customer findCustomerByEmail(String email);
	
}
