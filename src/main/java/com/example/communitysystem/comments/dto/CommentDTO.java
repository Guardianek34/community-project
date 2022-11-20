package com.example.communitysystem.comments.dto;

import com.example.communitysystem.comments.Comment;

public record CommentDTO(Long authorId, String content) {
    public Comment toComment(){
        return Comment.builder()
                .content(this.content)
                .build();
    }
}
