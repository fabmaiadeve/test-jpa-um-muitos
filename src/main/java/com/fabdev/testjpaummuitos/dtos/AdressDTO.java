package com.fabdev.testjpaummuitos.dtos;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fabdev.testjpaummuitos.enums.TypeAdress;

public class AdressDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Length(min=3, max=50, message="O tamanho deve ser entre 5 e 120 caracteres.")
	private String public_place;
	
	private String neighborhood;
	
	private String city;	
	
	private Integer typeAdress;
	
	private UUID customerId;
	
	public AdressDTO() {
	}

	public AdressDTO(String public_place, String neighborhood, String city, TypeAdress typeAdress, UUID customerId) {
		this.public_place = public_place;
		this.neighborhood = neighborhood;
		this.city = city;
		setTypeAdress(typeAdress);;
		this.customerId = customerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPublic_place() {
		return public_place;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public TypeAdress getTypeAdress() {
		return TypeAdress.valueOf(typeAdress)  ;
	}
	
	public void setTypeAdress(TypeAdress typeAdress) {
		if(typeAdress != null) {
			this.typeAdress = typeAdress.getCode();
		}		
	}

	public UUID getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "AdressDTO [public_place=" + public_place + ", neighborhood=" + neighborhood + ", city=" + city
				+ ", typeAdress=" + typeAdress + ", customerId=" + customerId + "]";
	}
	
	
	
	

}
