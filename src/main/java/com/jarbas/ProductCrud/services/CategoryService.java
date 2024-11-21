package com.jarbas.ProductCrud.services;

import com.jarbas.ProductCrud.entities.Category;
import com.jarbas.ProductCrud.exceptions.NotFoundException;
import com.jarbas.ProductCrud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category findCategoryById(UUID id){
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }


    public void deleteCategory(UUID id){
        categoryRepository.deleteById(id);
    }
}
