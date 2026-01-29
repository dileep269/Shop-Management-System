package com.kodnest.Shop_Management;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table

public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int i_id;
	@Column
	String i_url;
	@OneToOne
	@JoinColumn(name = "product_id")
	Product product;
	
	
	public Image(String i_url, Product product) {
		super();
		this.i_url = i_url;
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
	    return "Image{" +
	            "id=" + i_id +
	            ", url='" + i_url + '\'' +
	            '}';
	}

	public int getI_id() {
		return i_id;
	}
	public void setI_id(int i_id) {
		this.i_id = i_id;
	}
	
	public String getI_url() {
		return i_url;
	}
	public void setI_url(String i_url) {
		this.i_url = i_url;
	}
	public Image( String i_url) {
		super();
		this.i_url = i_url;
	}
	public Image() {
		super();
	}

}
