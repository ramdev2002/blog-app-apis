package com.jamesblog.blog_app.playload;

import com.jamesblog.blog_app.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    List<PostDto> contents;
    int pageNumber;
    int pageSize;
    long totalElement;
    boolean last;

}
