package com.jamesblog.blog_app.controller;

import com.jamesblog.blog_app.playload.ApiResponse;
import com.jamesblog.blog_app.playload.CategoryDto;
import com.jamesblog.blog_app.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/saveCategories")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
      CategoryDto created=this.categoryService.createCategory(categoryDto);
      return new ResponseEntity<CategoryDto>(created, HttpStatus.CREATED);
    }
    //update
    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable("id") Integer categoryId, @RequestBody CategoryDto categoryDto){
        CategoryDto updated=this.categoryService.updateCategory(categoryDto,categoryId);
        return ResponseEntity.ok(updated);
    }
    //delete
    @DeleteMapping("deleteCategory/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@Valid @PathVariable("id")Integer categoryId){
        this.categoryService.deleteCategory(categoryId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("category deleted successfull",true),HttpStatus.OK);
    }
    //get by Id
    @GetMapping("get/{id}")
    public ResponseEntity<CategoryDto> getbyId(@PathVariable("id") Integer categoryId){
        return ResponseEntity.ok(this.categoryService.categoryGetById(categoryId));
    }
    //get All
    @GetMapping("get")
    public ResponseEntity<List<CategoryDto>> getAll(){
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

}
