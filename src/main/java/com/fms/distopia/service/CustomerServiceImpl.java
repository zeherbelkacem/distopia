package com.fms.distopia.service;

import org.springframework.stereotype.Service;

import com.fms.distopia.repository.CustomerRepository;
import com.fms.distopia.security.SecurityService;

@Service
public class CustomerServiceImpl implements ICustomerService{

	private CustomerRepository customerRepository;
	private SecurityService securityService;

	public CustomerServiceImpl(CustomerRepository customerRepository, SecurityService securityService) {
		this.customerRepository = customerRepository;
		this.securityService = securityService;
	}
	
}
