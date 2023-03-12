package com.fabdev.testjpaummuitos.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fabdev.testjpaummuitos.enums.TypeAdress;

@Entity
@Table(name = "tb_adress")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_adress")
	private UUID id;
	
	private String public_place;
	
	private String neighborhood;
	
	private String city;
	
	private Integer typeAdress;
	
	@ManyToOne
	@JoinColumn(name = "id_customer")
	private Customer customer;
	
	public Adress() {
	}

	public Adress(UUID id, String public_place, String neighborhood, String city, TypeAdress typeAdress, Customer customer) {
		this.id = id;
		this.public_place = public_place;
		this.neighborhood = neighborhood;
		this.city = city;
		setTypeAdress(typeAdress);
		this.customer = customer;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPublic_place() {
		return public_place;
	}

	public void setPublic_place(String public_place) {
		this.public_place = public_place;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public TypeAdress getTypeAdress() {
		return TypeAdress.valueOf(typeAdress);
	}
	
	public void setTypeAdress(TypeAdress typeAdress) {
		if(typeAdress != null) {
			this.typeAdress = typeAdress.getCode();
		}		
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
