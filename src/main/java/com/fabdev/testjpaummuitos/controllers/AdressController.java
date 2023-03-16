package com.fabdev.testjpaummuitos.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabdev.testjpaummuitos.dtos.AdressDTO;
import com.fabdev.testjpaummuitos.models.Adress;
import com.fabdev.testjpaummuitos.models.Customer;
import com.fabdev.testjpaummuitos.services.AdressService;
import com.fabdev.testjpaummuitos.services.CustomerService;

@RestController
@RequestMapping("/adress")
public class AdressController {
	
	final AdressService adressService;
	final CustomerService customerService;
	
	public AdressController(AdressService adressService, CustomerService customerService) {
		this.adressService = adressService;
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<Adress> saveAdress(@RequestBody @Valid AdressDTO adressDTO) {
		
		Customer customer = findCustomerBeforeInsert(adressDTO.getCustomerId());
		
		Adress adress = new Adress(adressDTO.getPublic_place(), adressDTO.getNeighborhood(), adressDTO.getCity(), adressDTO.getTypeAdress(), customer);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(adressService.save(adress));
	}
	
	public Customer findCustomerBeforeInsert(UUID customer_id) throws IllegalArgumentException{
		
		Optional<Customer> customerOptional = customerService.findById(customer_id);
		
		if(customerOptional.isPresent()) {
			new IllegalArgumentException("Customer not found!");
		}
		return customerOptional.get();
	} 
	

}
