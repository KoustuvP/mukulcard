
package com.pnc.creditcard.domain;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

	@Id
	@NotNull(message="User id cannot be null")
	long userId;
	
	
	
	@Column
	@NotBlank(message="User name cannot be null or empty")
	String userName;
	
	@Column
	@NotNull(message="User id cannot be null")
	long ssn;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn
	@NotBlank(message="User name cannot be null or empty")
	Address address;
	
	@OneToMany(mappedBy="user")
	List<CreditCard>cards;
	
	public User(long userId, String userName, long ssn, Address address,List<CreditCard> cards) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.ssn = ssn;
		this.address = address;
		this.cards=cards;
	}
	public User() {
		super();
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<CreditCard> getCards() {
		return cards;
	}
	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", ssn=" + ssn + ", address=" + address
				+ ", cards=" + cards + "]";
	}
	
	
	
}
