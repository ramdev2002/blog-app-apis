package com.jamesblog.blog_app.repository;

import com.jamesblog.blog_app.entity.Category;
import com.jamesblog.blog_app.entity.Post;
import com.jamesblog.blog_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

}
