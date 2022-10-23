package com.example.communitysystem.community;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
class Post {
    @Id
    private UUID postId;
    private String title;
    private String content;
    @Lob
    private byte[] file;

    @ManyToOne
    private Community community;

    @OneToMany
    private List<Comment> comments;

    @OneToOne
    private VoteValue rateValue;
}
