package com.adminportal.service.impl;

import com.adminportal.domain.Category;
import com.adminportal.domain.Product;
import com.adminportal.domain.dto.ProductDto;
import com.adminportal.mapper.ProductMapper;
import com.adminportal.repository.ProductRepository;
import com.adminportal.utility.FileSave;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Autowired
    private ProductMapper mapper;
    @Mock
    private ProductRepository productRepository;

    @Mock
    private FileSave fileSave;

    @InjectMocks
    private ProductService productService;

    @Test
    public void save() throws Exception {
        //Given
        Category category = new Category("test_category");
        Product product = new Product("Test_product", new BigDecimal("100"), 2.00);
        ProductDto productDto = mapper.mapToProductDto(product);
        product.getCategories().add(category);
        //When
        Product result = productService.add(productDto);
        //Then
        Assert.assertEquals("Test_product", product.getName());
        Assert.assertEquals(new BigDecimal("100"), product.getPrice());
        Assert.assertEquals(2, product.getQuantity(), 2);
        Assert.assertEquals("test_category", product.getCategories().get(0).getName());

    }

}