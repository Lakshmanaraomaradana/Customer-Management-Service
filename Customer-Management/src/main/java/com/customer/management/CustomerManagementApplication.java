package com.customer.management;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerManagementApplication {
         static final Logger logger= LoggerFactory.getLogger(CustomerManagementApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
		
		logger.info("CustomermanagementApplication is started successfully");
	}

}
