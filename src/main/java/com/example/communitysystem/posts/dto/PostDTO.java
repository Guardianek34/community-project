package com.example.communitysystem.posts.dto;

import com.example.communitysystem.posts.Post;

public record PostDTO(String content, String author) {

    public Post toPost() {
        return Post.builder()
                .content(this.content)
                .author(this.author)
                .build();
    }
}
