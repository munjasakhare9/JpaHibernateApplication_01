package com.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tbl_products")
public class ProductEntity {

	@Id
	@Column(name = "product_id")
	private Integer product_id;

	@Column(name = "product_name")
	private String productName;

	private Integer quantity;

	@Column(name = "unit_price")
	private Double unitPrice;

	@Column(name = "CREATED_ON")
	@CreationTimestamp
	private LocalDateTime createdOn;

	@Column(name = "LASTUPDATED_ON")
	@UpdateTimestamp
	private LocalDateTime updatedOn;

	@Override
	public String toString() {
		return "ProductEntity [product_id=" + product_id + ", productName=" + productName + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

}
