package com.example.communitysystem.community;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
@Getter
class Comment {
    @Id
    private UUID CommentId;

    private String content;

    @OneToOne
    private Comment comment;

    @OneToOne
    private VoteValue votingScore;
}
