package com.thbs.ProductReactiveService.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.thbs.ProductReactiveService.Entity.ReactiveProduct;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<ReactiveProduct, Integer> {

}
