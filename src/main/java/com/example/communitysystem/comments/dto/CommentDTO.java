package com.example.communitysystem.comments.dto;

import com.example.communitysystem.comments.Comment;

public record CommentDTO(Long authorId, String content) {
    public Comment toComment(){
        return Comment.builder()
                .authorId(this.authorId)
                .content(this.content)
                .build();
    }
}
