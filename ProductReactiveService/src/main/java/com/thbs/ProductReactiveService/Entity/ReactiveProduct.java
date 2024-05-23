
package com.thbs.ProductReactiveService.Entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Table;

@org.springframework.data.relational.core.mapping.Table("reactive_product")
public class ReactiveProduct {

	@Id
	private Integer productId;
	private String productName;
	private String category;
	private Double price;

	public ReactiveProduct() {
		super();
	}

	public ReactiveProduct(Integer productId, String productName, String category, Double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", price=" + price + "]";
	}

}
