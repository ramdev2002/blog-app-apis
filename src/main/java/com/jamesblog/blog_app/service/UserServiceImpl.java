package com.jamesblog.blog_app.service;

import com.jamesblog.blog_app.entity.User;
import com.jamesblog.blog_app.playload.UserDto;
import com.jamesblog.blog_app.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.jamesblog.blog_app.exeception.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser=this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto getById(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFundException("User","id",userId));

        return this.userToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFundException (
                "User","id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser=this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users=this.userRepo.findAll();
        List<UserDto> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        //return users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;


    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFundException("User","id",userId));
        userRepo.delete(user);

    }

    public User dtoToUser(UserDto userDto){
        //Map the UserDto class to User class
        User user=this.modelMapper.map(userDto,User.class);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(user.getAbout());

        return user;
    }

    public UserDto userToDto(User user){
        //map the User Class to the UserDto class
        UserDto userDto = this.modelMapper.map(user,UserDto.class);

        return userDto;
    }
}
