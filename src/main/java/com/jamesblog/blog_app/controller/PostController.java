package com.jamesblog.blog_app.controller;

import com.jamesblog.blog_app.entity.Post;
import com.jamesblog.blog_app.playload.ApiResponse;
import com.jamesblog.blog_app.playload.PostDto;
import com.jamesblog.blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PostController {
    @Autowired
    private PostService postService;


    //create post using userId and categoryId
    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
       PostDto post= this.postService.createPost(postDto,userId,categoryId);
       return  new ResponseEntity<>(post, HttpStatus.CREATED);
    }


    //get post by userId
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> posts=this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    //get post by categoryId
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts=this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
    }

    //get post by postId
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto get=this.postService.getPostById(postId);
        return ResponseEntity.ok(get);
    }

    // get all the post
    @GetMapping("/allposts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> posts=this.postService.getAllPost();
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }
    //delete post
    @DeleteMapping("delete/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ApiResponse("post delete successfully",true);
    }

    //update post
    @PutMapping("update/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId) {
        PostDto updated = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
