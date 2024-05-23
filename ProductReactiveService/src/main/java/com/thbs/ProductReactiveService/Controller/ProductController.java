package com.thbs.ProductReactiveService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.ProductReactiveService.Entity.ReactiveProduct;
import com.thbs.ProductReactiveService.Service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/reactive-product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public Flux<ReactiveProduct> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Mono<ReactiveProduct> getProductById(@PathVariable Integer productId) {
		return productService.getProductById(productId);
	
	}
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody ReactiveProduct product) {
		productService.addProduct(product);
	    return new ResponseEntity<>("Product added successfully with Id: " + product.getProductId(), HttpStatus.CREATED);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer productId) {
		productService.deleteProductById(productId);
	    return new ResponseEntity<>("Product deleted successfully with Id: " + productId, HttpStatus.OK);
	}
	
	//@PutMapping("/{productId}")
	//public ResponseEntity<String> updateProduct(@RequestBody Product updatedProduct,@PathVariable Integer productId) {
		//productService.updateProduct(productId,updatedProduct);
	    //return new ResponseEntity<>("Product updated successfully with Id: " + productId, HttpStatus.OK);
	//}

}
