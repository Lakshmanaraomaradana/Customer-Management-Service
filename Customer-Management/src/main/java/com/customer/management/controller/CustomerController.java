package com.customer.management.controller;

import static com.customer.management.constants.CustomerConstants.MODULE_CUSTOMER;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.management.bean.Response;
import com.customer.management.entity.Customer;
import com.customer.management.service.CustomerService;
@RequestMapping("/customers")
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerSer;
	
	@GetMapping("/getCustomer")
	public List<Customer> getAllCustomers(){
		
		return customerSer.getAllCustomers();
		
	}
	@PostMapping("/addCustomer")
	public Response<List<String>> saveCustomer(@RequestBody Customer customer)
	{
		customerSer.saveCustomer(customer);
		Response<List<String>>exceptionResponse=Response.<List<String>>builder()
				.code(HttpStatus.OK)
				.timestamp(new Date())
				.module(MODULE_CUSTOMER)
				.build();
		return exceptionResponse;
	}
	@GetMapping("/getById/{id}")
	public Customer findCustomerById(@PathVariable int id)
	{
		return customerSer.findCustomerById(id);
	}
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		return customerSer.updateCustomer(customer);
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteCustomer(@PathVariable int id)
	{
		customerSer.deleteCustomerById(id);
		return ; 
	}
	@GetMapping("/findByEmail/{email}")
	public Customer findByEmail(@PathVariable String email)
	{
		return customerSer.findCustomerByEmail(email);
	}

}
