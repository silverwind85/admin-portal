package com.adminportal.utility.Converter;

import com.adminportal.domain.Category;
import org.springframework.core.convert.converter.Converter;

public class CategoryConverter implements Converter<String,Category> {
    @Override
    public Category convert(String s) {
        return new Category(s);
    }
}
