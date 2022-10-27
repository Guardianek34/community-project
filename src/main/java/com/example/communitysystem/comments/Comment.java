package com.example.communitysystem.comments;

import com.example.communitysystem.posts.Post;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Post post;

    private Long authorId;

    private ZonedDateTime timeStamp;

    private String content;

    @Version
    private Long version;
}
