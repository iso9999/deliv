package com.ensa.deliveroo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="order_")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	public Order(Date date, Client client) {
		super();
		this.date = date;
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(
			fetch = FetchType.EAGER,
		mappedBy="id.order"
	)
	private Set<Product> products = new HashSet<>();
	
	public void addProduct(Product product,int quantity)
	{
		products.add(product);
		product.getOrders().add(this);
	}
	
//	public void removeProduct(Product product)
//	{
//		for (Iterator<ProductOrder> iterator = products.iterator(); iterator.hasNext();)
//		{
//			ProductOrder productOrder = iterator.next();
//			if(productOrder.getId().getOrder().equals(this) && productOrder.getId().getProduct().equals(product))
//			{
//				iterator.remove();
//				productOrder.getId().getProduct().getOrders().remove(productOrder);
//				productOrder.getId().setOrder(null);
//				productOrder.getId().setProduct(null);
//			}
//		}
//	}
	public Order() {
		super();
	}

	public Order(Date date) {
		super();
		this.date = date;
	}

	
	public Order(Date date, Client client, Set<Product> products) {
		super();
		this.date = date;
		this.client = client;
		this.products = products;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		Order other = (Order) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}
	
	
	
	
}
