package com.thbs.ProductService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.ExceptionHandling.ProductNotFoundException;
import com.thbs.ProductService.Entity.Product;
import com.thbs.ProductService.Repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer productId) {
		
		Optional<Product> productOpt = productRepository.findById(productId);
		if(productOpt.isPresent())
			return productOpt.get();
		else
			throw new ProductNotFoundException("Product not found with productId:"+productId);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void deleteProductById(Integer productId) {
		Product product = getProductById(productId);
		productRepository.delete(product);

	}

	@Override
	public void updateProduct(Integer productId, Product updatedProduct) {
		Product product = getProductById(productId);
		product.setProductName(updatedProduct.getProductName());
		product.setCategory(updatedProduct.getCategory());
		product.setPrice(updatedProduct.getPrice());
		productRepository.save(product);

	}

}
