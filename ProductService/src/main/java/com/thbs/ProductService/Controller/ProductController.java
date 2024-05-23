package com.thbs.ProductService.Controller;

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

import com.thbs.ProductService.Entity.Product;
import com.thbs.ProductService.Service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping()
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Integer productId) {
		return productService.getProductById(productId);
	
	}
	
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	    return new ResponseEntity<>("Product added successfully with Id: " + product.getProductId(), HttpStatus.CREATED);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable Integer productId) {
		productService.deleteProductById(productId);
	    return new ResponseEntity<>("Product deleted successfully with Id: " + productId, HttpStatus.OK);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<String> updateProduct(@RequestBody Product updatedProduct,@PathVariable Integer productId) {
		productService.updateProduct(productId,updatedProduct);
	    return new ResponseEntity<>("Product updated successfully with Id: " + productId, HttpStatus.OK);
	}

}
