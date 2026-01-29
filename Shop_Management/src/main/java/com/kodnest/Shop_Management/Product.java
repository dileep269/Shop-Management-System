package com.kodnest.Shop_Management;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
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

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int p_id;
	@Column
	private String p_name;
	@Column
	private BigDecimal p_price;
	@Column
	private String p_description;
	@OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
	Image image;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
		image.setProduct(this);
	}
	
	public Product(String p_name, BigDecimal p_price, String p_description, Image image) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_description = p_description;
		this.image = image;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getName() {
		return p_name;
	}
	public void setName(String p_name) {
		this.p_name = p_name;
	}
	public BigDecimal getP_price() {
		return p_price;
	}
	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}
	public String getP_description() {
		return p_description;
	}
	
	@Override
	public String toString() {
	    return "Product{" +
	            "id=" + p_id +
	            ", name='" + p_name + '\'' +
	            ", price=" + p_price +
	            '}';
	}

	public void setP_description(String p_description) {
		this.p_description = p_description;
	}
	
	public Product() {
		super();
	}
	
	

}
