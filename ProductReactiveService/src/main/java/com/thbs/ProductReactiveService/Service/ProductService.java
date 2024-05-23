package com.thbs.ProductReactiveService.Service;

import java.util.List;

import com.thbs.ProductReactiveService.Entity.ReactiveProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface ProductService {

	Flux<ReactiveProduct> getAllProducts();
	Mono<ReactiveProduct> getProductById(Integer productId);
	void addProduct(ReactiveProduct product);
	void deleteProductById(Integer productId);
	void updateProduct(Integer productId, ReactiveProduct updatedProduct);
}
