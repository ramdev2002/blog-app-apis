package com.jamesblog.blog_app.service;

import com.jamesblog.blog_app.entity.Category;
import com.jamesblog.blog_app.exeception.ResourceNotFundException;
import com.jamesblog.blog_app.playload.CategoryDto;
import com.jamesblog.blog_app.repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat=this.modelMapper.map(categoryDto,Category.class);
        Category addCat=this.categoryRepo.save(cat);
        return modelMapper.map(addCat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category exist = this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFundException("Category", "categoryId", categoryId));
        exist.setCategoryTitle(categoryDto.getCategoryTitle());
        exist.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updated=this.categoryRepo.save(exist);
        return this.modelMapper.map(updated,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFundException("Category","categoryId",categoryId));

        this.categoryRepo.delete(cat);
    }

    @Override
    public CategoryDto categoryGetById(Integer categoryId) {
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFundException("Category","categoryId",categoryId));

        return this.modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories=this.categoryRepo.findAll();
        List<CategoryDto> catDtos =categories.stream().map((cat)->modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
