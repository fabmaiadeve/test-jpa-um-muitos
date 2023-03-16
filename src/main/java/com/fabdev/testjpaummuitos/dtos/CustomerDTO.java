package com.fabdev.testjpaummuitos.dtos;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fabdev.testjpaummuitos.models.Adress;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message="Preenchimento obrigatório.")
	private String name;
	
	@NotBlank(message="Preenchimento obrigatório.")
	@Email
	private String email;

	private List<Adress> adresses;
	
	public CustomerDTO() {
	}
	
	public CustomerDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", email=" + email + "]";
	}
	
	

}
