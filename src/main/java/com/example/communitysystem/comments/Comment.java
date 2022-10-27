package com.example.communitysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Comment {

    @GeneratedValue
    @Id
    private Long id;

    private Long postID;

    private String author;

    private String content;

    @Version
    private Long version;
}
