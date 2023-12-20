package com.jamesblog.blog_app.playload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class UserDto {
    private int id;
    @NotBlank
    @Size(min = 3,max = 15,message = "name should be between 3 to 15")
    private String name;
    @Email
    private String email;
    @NotBlank(message = "password can not be blank")
    private String password;
    @NotBlank(message = "about can not be blank")
    private String about;
}

