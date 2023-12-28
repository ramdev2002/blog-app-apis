package com.jamesblog.blog_app.service;

import com.jamesblog.blog_app.playload.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);


    //get by id
    CategoryDto categoryGetById(Integer categoryId);


    //get all
    List<CategoryDto> getAllCategories();

}
