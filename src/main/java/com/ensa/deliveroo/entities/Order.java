package com.ensa.deliveroo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="order_")
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	@JsonManagedReference
	private Client client;
	
	@OneToMany(
		mappedBy="order"
	)
	@JsonManagedReference
	private List<ProductOrder> products = new ArrayList<>();
	
	public void addProduct(Product product,int quantity)
	{
		ProductOrder productOrder = new ProductOrder( product, this,quantity);
		products.add(productOrder);
		product.getOrders().add(productOrder);
	}
	
//	public void removeProduct(Product product)
//	{
//		for (Iterator<ProductOrder> iterator = products.iterator(); iterator.hasNext();)
//		{
//			ProductOrder productOrder = iterator.next();
//			
//			if(productOrder.equals(this) && productOrder.getProduct().equals(product))
//			{
//				iterator.remove();
//				productOrder.getProduct().getOrders().remove(productOrder);
//				productOrder.setOrder(null);
//				productOrder.setProduct(null);
//			}
//		}
//	}
	public Order() {
		super();
	}

	public Order(Date date, Client client) {
		super();
		this.date = date;
		this.client = client;
	}

	public Order(Date date) {
		super();
		this.date = date;
	}

	
	public Order(Date date, Client client, List<ProductOrder> products) {
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


	public List<ProductOrder> getProducts() {
		return products;
	}


	public void setProducts(List<ProductOrder> products) {
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
