package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products_info")
@Data
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productID;
	private String productName;
	@Column(name = "price")
	private int productPrice;
	private String productCategory;
	@Column(name = "quantity")
	private int productQuantity;

	public Product() {
		System.out.println("default constructor of product");
	}

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
