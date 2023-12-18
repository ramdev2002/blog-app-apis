package com.jamesblog.blog_app.repository;

import com.jamesblog.blog_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
