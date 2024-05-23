package com.thbs.ProductService.Service;

import java.util.List;

import com.thbs.ProductService.Entity.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	Product getProductById(Integer productId);
	void addProduct(Product product);
	void deleteProductById(Integer productId);
	void updateProduct(Integer productId, Product updatedProduct);
}
