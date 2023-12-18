package com.jamesblog.blog_app.service;

import com.jamesblog.blog_app.entity.User;
import com.jamesblog.blog_app.playload.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);
    UserDto getById(Integer userId);
    UserDto updateUser(UserDto userDto,Integer userId);
    List<UserDto> getAllUser();
    void deleteUser(Integer userId);


}
