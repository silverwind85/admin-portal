package com.adminportal.service;

import com.adminportal.domain.Category;
import com.adminportal.domain.Product;
import com.adminportal.domain.dto.ProductDto;

import java.util.List;

public interface IProductService {
    Product add(ProductDto productDto);
    List<Product> getProducts();
    Product findById(Long id);
    void delete(Long id);



}
