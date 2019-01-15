package com.ensa.deliveroo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "product_order")
public class ProductOrder implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonManagedReference
	private Product product; 
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Order order;
	
	private int quantity;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductOrder(Product product, Order order, int quantity) {
		super();
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public ProductOrder() {
		super();
	}
	
}
