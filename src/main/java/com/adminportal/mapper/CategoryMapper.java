package com.adminportal.mapper;


import com.adminportal.domain.Category;
import com.adminportal.domain.Product;
import com.adminportal.domain.dto.CategoryDto;
import com.adminportal.domain.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    @Autowired
    private ProductMapper productMapper;

    public List<CategoryDto> mapToCategoryDtos(List<Category> categories) {
        return categories.stream()
                .map(category -> new CategoryDto(
                        category.getId(),
                        category.getName(),
                        category.getDescription(),
                        null,
                        category.getImage())).collect(Collectors.toList());
    }

    public List<Category> mapToCategories(List<CategoryDto> categoryDtos) {
        return categoryDtos.stream()
                .map(categoryDto -> new Category(
                        categoryDto.getId(),
                        categoryDto.getName(),
                        categoryDto.getDescription(),
                        null,
                        categoryDto.getImage())).collect(Collectors.toList());

    }
    public CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(category.getId(),
                category.getName(),
                category.getDescription(),
                mapToProductDtos(category.getProducts()),
                category.getImage());
    }

    public List<ProductDto> mapToProductDtos(List<Product> products) {
        return products.stream()
                .map(product -> new ProductDto(product.getId(),
                        product.getName(),
                        product.getPrice(),
                        null,
                        product.getShippingWeight(),
                        product.isAvailable(),
                        product.getDescription(),
                        product.getQuantity(),
                        product.getImagePath(),
                        product.getImage(),
                        product.getProductToCartItems())).collect(Collectors.toList());

    }

}
