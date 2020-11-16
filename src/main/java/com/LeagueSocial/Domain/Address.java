package com.LeagueSocial.Domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String street;
	private String zipCode;
	private String number;
	private String district;
	private String complement;

	public Address(){}

	public Address(String street, String zipCode, String number, String district, String complement){
		this.street = street;
		this.zipCode = zipCode;
		this.number = number;
		this.district = district;
		this.complement = complement;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private City city;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
