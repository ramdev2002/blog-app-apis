package com.jamesblog.blog_app.service;

import com.jamesblog.blog_app.entity.Category;
import com.jamesblog.blog_app.entity.Post;
import com.jamesblog.blog_app.entity.User;
import com.jamesblog.blog_app.exeception.ResourceNotFundException;
import com.jamesblog.blog_app.playload.PostDto;
import com.jamesblog.blog_app.repository.CategoryRepo;
import com.jamesblog.blog_app.repository.PostRepo;
import com.jamesblog.blog_app.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFundException("User","userId",userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFundException("Category","categoryId",categoryId));
        Post post=this.modelMapper.map(postDto,Post.class);
        post.setImage_name("default.png");
        post.setAdded_date(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post saved=this.postRepo.save(post);
        return modelMapper.map(saved,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFundException("Post","postId",postId));
        post.setPost_title(postDto.getPost_title());
        post.setContent(post.getContent());
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFundException("Post","postId",postId));
       this.postRepo.delete(post);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFundException("Post","postId",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> post=this.postRepo.findAll();
        List<PostDto> postDtos=post.stream().map((pos)->this.modelMapper.map(pos,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        // Retrieve a Category object based on the provided categoryId
        Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFundException("Category","categoryId",categoryId));

        // Retrieve a list of Post objects associated with the given Category
        List<Post> post=this.postRepo.findByCategory(cat);

        // Convert the list of Post objects to a list of PostDto objects using ModelMapper
        List<PostDto> postDtos=post.stream().map((pos)->this.modelMapper.map(pos,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        //retrieve a User object based on the provided userId
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFundException("User","userId",userId));
        //Retrieve a list of post Objects associated with the given User
        List<Post> post=this.postRepo.findByUser(user);
        //Convert the list of Post object to a list of PostDto objects using ModelMapper
        List<PostDto> postDtos=post.stream().map((pos)->this.modelMapper.map(pos,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
