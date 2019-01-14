package com.ensa.deliveroo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_order")
public class ProductOrder {

	
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product; 
	
	@Id
	@ManyToOne
	@JoinColumn(name = "order_id")
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
