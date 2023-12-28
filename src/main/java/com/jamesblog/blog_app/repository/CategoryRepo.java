package com.jamesblog.blog_app.repository;

import com.jamesblog.blog_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
