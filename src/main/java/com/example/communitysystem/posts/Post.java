package com.example.communitysystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private String author;

    @Version
    private Long version;

}
