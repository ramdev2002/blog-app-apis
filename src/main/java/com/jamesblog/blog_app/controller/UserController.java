package com.jamesblog.blog_app.controller;

import com.jamesblog.blog_app.playload.ApiResponse;
import com.jamesblog.blog_app.playload.UserDto;
import com.jamesblog.blog_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //POST - create the users
    @PostMapping("/post")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto saveUserDto =this.userService.saveUser(userDto);
        return new ResponseEntity<>(saveUserDto,HttpStatus.CREATED);
    }

    //PUT - update the users
    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable("userId") Integer id,
                                              @RequestBody UserDto userDto){
        UserDto updatedUser=this.userService.updateUser(userDto,id);
        return ResponseEntity.ok(updatedUser);
    }

    //DELETE - delete the user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer id){
        this.userService.deleteUser(id);
        return new  ResponseEntity(new ApiResponse("user deleted Successfully",true),HttpStatus.OK);
    }

    //GET - get the users
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(this.userService.getAllUser());

    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer id){
        return ResponseEntity.ok(this.userService.getById(id));
    }
}
