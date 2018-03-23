package com.adminportal.service.impl;

import com.adminportal.domain.Category;
import com.adminportal.domain.Product;
import com.adminportal.domain.dto.ProductDto;
import com.adminportal.mapper.ProductMapper;
import com.adminportal.repository.ProductRepository;
import com.adminportal.service.IProductService;
import com.adminportal.utility.FileSave;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final static String PATH="src/main/resources/static/img/product/";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FileSave fileSave;

    @Autowired
    private ProductMapper mapper;


    @Override
    public Product add(ProductDto productDto) {
        logger.info("Adding new product with information: {}", productDto);
        Product product = mapper.mapToProduct(productDto);
        Category categoryName = product.getCategories().get(0);
        if(StringUtils.isNumeric(categoryName.getName())){
            Category category = categoryService.findById(Long.parseLong(categoryName.getName()));
            category.getProducts().add(product);
            product.getCategories().remove(0);
            product.getCategories().add(category);

            productRepository.save(product);
        }else{
            productRepository.save(product);
        }

        try {
            String path = PATH+product.getId()+".png";
            Path p = Paths.get(path);
            if(Files.exists(p)){
                File file =new File(path);
                file.delete();
            }
            if(product.getImage().getSize()>0){
                product.setImagePath("img/product/"+product.getId()+".png");
                productRepository.save(product);
                fileSave.save(product.getImage().getBytes(), product.getId()+".png");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    /*@Override
    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            logger.warn("Not found Product");
        }
        return mapper.mapToProductDto(product);
    }*/
    public Product findById(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            logger.warn("Not found Product");
        }
        return product;
    }

    public void  delete(Long id ){
        productRepository.delete(productRepository.findById(id));

    }
}
