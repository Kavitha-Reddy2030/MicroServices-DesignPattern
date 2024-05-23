package com.thbs.ProductService.Repository;

import org.springframework.data.repository.CrudRepository;

import com.thbs.ProductService.Entity.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {

}
