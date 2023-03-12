package com.fabdev.testjpaummuitos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fabdev.testjpaummuitos.models.Customer;
import com.fabdev.testjpaummuitos.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Transactional
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findById(UUID id) {
		return customerRepository.findById(id);
	}
	
	@Transactional
	public void delete(Customer customer) {
		customerRepository.delete(customer);
	}

}
