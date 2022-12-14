package com.example.communitysystem.comments;

import com.example.communitysystem.auth.UserAuth;
import com.example.communitysystem.posts.Post;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime timeStamp;
    private String content;
    private Boolean hidden;

    @ManyToOne
    private Post post;

    @OneToOne
    private UserAuth author;

    @OneToMany(mappedBy = "comment")
    private List<CommentScore> scores;

    @Version
    private Long version;
}
