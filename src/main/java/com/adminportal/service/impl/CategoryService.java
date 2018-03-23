package com.adminportal.service.impl;

import com.adminportal.domain.Category;
import com.adminportal.domain.dto.CategoryDto;
import com.adminportal.mapper.CategoryMapper;
import com.adminportal.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    /*public CategoryDto findById(Long id){
        Category category = categoryRepository.findById(id);
        if(category==null){
            logger.info("No found category");
        }
        return categoryMapper.mapToCategoryDto(category);
    }*/
    public Category findById(Long id){
        return categoryRepository.findById(id);
    }


}
