package com.ensa.deliveroo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="product_order")
public class ProductOrder {
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

	@EmbeddedId
	private ProductOrderId id;
	
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orderId")
	private Order order;

	public ProductOrder() {
		super();
	}

	public ProductOrder(int quantity, Product product, Order order) {
		this.quantity = quantity;
		this.product = product;
		this.order = order;
		this.id= new ProductOrderId(product.getId(), order.getId());
	}
	
	
}
