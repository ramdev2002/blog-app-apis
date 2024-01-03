package com.jamesblog.blog_app.service;

import com.jamesblog.blog_app.entity.Post;
import com.jamesblog.blog_app.playload.PostDto;
import com.jamesblog.blog_app.playload.PostResponse;

import java.util.List;

public interface PostService {
    // create post
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update post
    PostDto updatePost(PostDto postDto,Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get post by Id
    PostDto getPostById(Integer postId);

    //get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    //get all post by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all post by User
    List<PostDto> getPostByUser(Integer userId);

    //search all post
    List<PostDto> searchPost(String keyword);
}
