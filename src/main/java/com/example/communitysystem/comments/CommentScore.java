package com.example.communitysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CommentScore {

    private static final Integer ZERO = 0;

    @GeneratedValue
    @Id
    private Long id;

    private Long commentId;

    private Integer numberOfLikes = ZERO;
}
