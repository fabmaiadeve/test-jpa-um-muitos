package com.fabdev.testjpaummuitos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabdev.testjpaummuitos.dtos.CustomerDTO;
import com.fabdev.testjpaummuitos.models.Customer;
import com.fabdev.testjpaummuitos.services.AdressService;
import com.fabdev.testjpaummuitos.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	final CustomerService customerService;
	final AdressService adressService;
	
	public CustomerController(CustomerService customerService, AdressService adressService) {
		this.customerService = customerService;
		this.adressService = adressService;
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		
		Customer customer = new Customer(customerDTO.getName(), customerDTO.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAllCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable(value = "id") UUID id) {
		
		Optional<Customer> customerOptional = customerService.findById(id);
		
		if(customerOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		} 
		return ResponseEntity.status(HttpStatus.OK).body(customerOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable(value = "id") UUID id) {
		
		Optional<Customer> customerOptional = customerService.findById(id);
		
		if(customerOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
		
		if(!customerOptional.get().getAdresses().isEmpty()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("It's not possible to delete the record because the key exists in another table.");
		}
		
		customerService.delete(customerOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Customer record deleted successfully!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
										 @RequestBody @Valid CustomerDTO customerDTO) {
		
		Optional<Customer> customerOptional = customerService.findById(id);
		
		if(customerOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
		}
		
		Customer customer = new Customer(customerDTO.getName(), customerDTO.getEmail());
		customer.setId(customerOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(customerService.save(customer));
	}

}
