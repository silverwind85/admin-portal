package com.adminportal.repository;


import com.adminportal.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findAll();
    Category findById(Long Id);
}
