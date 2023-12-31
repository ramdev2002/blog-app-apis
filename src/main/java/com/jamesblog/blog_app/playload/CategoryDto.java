package com.jamesblog.blog_app.playload;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int categoryId;
    @NotBlank
    private String categoryTitle;
    @NotBlank
    private String categoryDescription;
}
