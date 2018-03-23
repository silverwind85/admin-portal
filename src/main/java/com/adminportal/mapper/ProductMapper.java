package com.adminportal.mapper;


import com.adminportal.domain.Product;

import com.adminportal.domain.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getPrice(),
                categoryMapper.mapToCategoryDtos(product.getCategories()),
                product.getShippingWeight(),
                product.isAvailable(),
                product.getDescription(),
                product.getQuantity(),
                product.getImagePath(),
                product.getImage(),
                product.getProductToCartItems()
        );
    }

    public Product mapToProduct(ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                categoryMapper.mapToCategories(productDto.getCategoryDtos()),
                productDto.getShippingWeight(),
                productDto.isAvailable(),
                productDto.getDescription(),
                productDto.getQuantity(),
                productDto.getImagePath(),
                productDto.getImage(),
                productDto.getProductToCartItems());

    }



    public List<ProductDto> mapToProductDtos(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getId(),
                        product.getName(),
                        product.getPrice(),
                        categoryMapper.mapToCategoryDtos(product.getCategories()),
                        product.getShippingWeight(),
                        product.isAvailable(),
                        product.getDescription(),
                        product.getQuantity(),
                        product.getImagePath(),
                        product.getImage(),
                        product.getProductToCartItems())).collect(Collectors.toList());

    }
    public List<ProductDto> mapToProductDtosWithouseImage(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getId(),
                        product.getName(),
                        product.getPrice(),
                        categoryMapper.mapToCategoryDtos(product.getCategories()),
                        product.getShippingWeight(),
                        product.isAvailable(),
                        product.getDescription(),
                        product.getQuantity()
                        )).collect(Collectors.toList());

    }

    public List<Product> mapToProducts(List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(productDto -> new Product(productDto.getId(),
                        productDto.getName(),
                        productDto.getPrice(),
                        categoryMapper.mapToCategories(productDto.getCategoryDtos()),
                        productDto.getShippingWeight(),
                        productDto.isAvailable(),
                        productDto.getDescription(),
                        productDto.getQuantity(),
                        productDto.getImagePath(),
                        productDto.getImage(),
                        productDto.getProductToCartItems())).collect(Collectors.toList());

    }
}


