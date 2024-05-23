package com.thbs.ProductReactiveService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.thbs.ProductReactiveService.Entity.ReactiveProduct;
import com.thbs.ProductReactiveService.Repository.ProductRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Flux<ReactiveProduct> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Mono<ReactiveProduct> getProductById(Integer productId) {

		return productRepository.findById(productId);
	}

	@Override
	public void addProduct(ReactiveProduct product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProductById(Integer productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public void updateProduct(Integer productId, ReactiveProduct updatedProduct) {
		
	}

}
