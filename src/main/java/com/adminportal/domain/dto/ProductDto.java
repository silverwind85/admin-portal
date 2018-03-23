package com.adminportal.domain.dto;

import com.adminportal.domain.Category;
import com.adminportal.domain.ProductToCartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private List<CategoryDto> categoryDtos = new ArrayList<>();
    private double shippingWeight;
    private boolean isAvailable;
    private String description;
    private int quantity;
    private String imagePath;
    private MultipartFile image;
    private List<ProductToCartItem> productToCartItems;

    public ProductDto(Long id, String name, BigDecimal price, List<CategoryDto> categoryDtos,
                   double shippingWeight, boolean isAvailable, String description, int quantity) {
        this.name = name;
        this.price = price;
        this.categoryDtos = categoryDtos;
        this.shippingWeight = shippingWeight;
        this.isAvailable = isAvailable;
        this.description = description;
        this.quantity = quantity;


    }
}