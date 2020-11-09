package com.winify.shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="creation_time")
	private Timestamp creationTime;
	
	public int getId() {
		return id;
	}

	@Column(name="price")
	private BigDecimal  price;
	
	@Column(name="stock")
	private int stock;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, 
			             CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="owner_id")
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public BigDecimal  getPrice() {
		return price;
	}

	public void setPrice(BigDecimal  price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", creationTime=" + creationTime + ", price=" + price
				+ ", stock=" + stock + ", user=" + user + "]";
	}
	
	
}
