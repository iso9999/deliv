package com.ensa.deliveroo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="product_order")
public class ProductOrder {
	@Id
	private ProductOrderId id;
	private int quantity;
	public ProductOrder() {
		super();
	}

	public ProductOrder(int quantity, Product product, Order order) {
		this.quantity = quantity;
		this.id= new ProductOrderId(product, order);
	}
	public ProductOrderId getId() {
		return id;
	}

	public void setId(ProductOrderId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
