package com.fabdev.testjpaummuitos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fabdev.testjpaummuitos.models.Adress;
import com.fabdev.testjpaummuitos.repositories.AdressRepository;

@Service
public class AdressService {
	
	final AdressRepository adressRepository;

	public AdressService(AdressRepository adressRepository) {
		this.adressRepository = adressRepository;
	}
	
	@Transactional
	public Adress save(Adress adress) {
		return adressRepository.save(adress);
	}
	
	public List<Adress> listAll() {
		return adressRepository.findAll();
	}
	
	public Optional<Adress> findById(UUID id) {
		return adressRepository.findById(id);
	}
	
	public void delete(Adress adress) {
		adressRepository.delete(adress);
	}
	
	
	
	

}
