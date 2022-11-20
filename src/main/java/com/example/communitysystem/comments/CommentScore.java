package com.example.communitysystem.comments;

import com.example.communitysystem.user.UserProfile;

import javax.persistence.*;

@Entity
public class CommentScore {

    private static final Integer ZERO = 0;
    private static final Integer HIDDEN_THRESHOLD_VALUE = -100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Comment comment;

    @ManyToOne
    private UserProfile user;

    private Integer value = ZERO;

    public void likeComment() { this.value = 1;}
    public void dislikeComment() { this.value = -1;}
}
