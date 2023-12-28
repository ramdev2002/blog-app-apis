package com.jamesblog.blog_app.playload;

import com.jamesblog.blog_app.entity.Category;
import com.jamesblog.blog_app.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PostDto {
    private int postId;
    private String post_title;
    private String content;
    private String image_name;
    private Date added_date;

    private CategoryDto category;

    private UserDto user;


}
