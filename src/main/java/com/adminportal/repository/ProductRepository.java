package com.adminportal.repository;

import com.adminportal.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();
    Product findById(Long id);

}
