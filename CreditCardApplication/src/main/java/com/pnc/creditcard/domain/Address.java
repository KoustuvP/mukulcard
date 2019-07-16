package com.pnc.creditcard.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Address {

	@Id
	@GeneratedValue	
	long id;
	
	@Column
	@NotBlank(message="street can not be null or empty")	
	String street;
	
	@Column
	@NotBlank(message="locality can not be null or empty")
	String locality;
	
	@Column
	@NotBlank(message="city can not be null or empty")
	String city;
	
	@Column
	@NotBlank(message="state can not be null or empty")
	String state;
	
	@OneToMany(mappedBy="address",cascade= {CascadeType.ALL})
	List<User> user;
	public Address(long id, String street, String locality, String city, String state, List<User> user) {
		super();
		this.id = id;
		this.street = street;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.user=user;
	}
	public Address() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", locality=" + locality + ", city=" + city + ", state="
				+ state + ", user=" + user + "]";
	}
	
	
}
