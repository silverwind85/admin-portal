package com.adminportal.domain.dto;

import com.adminportal.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private List<ProductDto> productsDtos ;
    private MultipartFile image;
}
