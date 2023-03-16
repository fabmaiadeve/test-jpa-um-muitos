package com.fabdev.testjpaummuitos.models;

import java.io.Serializable;
import java.util.Objects;
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
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	public Adress() {
	}

	public Adress(String public_place, String neighborhood, String city, TypeAdress typeAdress, Customer customerId) {
		this.public_place = public_place;
		this.neighborhood = neighborhood;
		this.city = city;
		setTypeAdress(typeAdress);
		this.customerId = customerId;
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

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", public_place=" + public_place + ", neighborhood=" + neighborhood + ", city="
				+ city + ", typeAdress=" + typeAdress + ", customer=" + customerId + "]";
	}
	
	
}
