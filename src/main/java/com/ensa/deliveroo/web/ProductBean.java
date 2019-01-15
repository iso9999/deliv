package com.ensa.deliveroo.web;

public class ProductBean {

	private Long id;
	private String label;
	private int quantity;
	private double price;
	private String img_url;
	public ProductBean(Long id, String label, int quantity, double price, String img_url) {
		super();
		this.id = id;
		this.label = label;
		this.quantity = quantity;
		this.price = price;
		this.img_url = img_url;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public ProductBean() {
		super();
	}

}