package com.ensa.deliveroo.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String LastName;
	private String email;
	
	@OneToMany(
	        mappedBy = "client",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private Set<Order> orders = new HashSet<>();

	public void addOrder(Order order)
	{
		orders.add(order);
		order.setClient(this);
	}
	
	public void removeOrder(Order order)
	{
		orders.remove(order);
		order.setClient(null);
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Set<Order> getOrders() {
		return orders;
	}


	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}


	public Client() {
		super();
	}


	public Client(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
	}
	
	
}
