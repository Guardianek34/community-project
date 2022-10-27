package com.example.communitysystem.posts;

import com.example.communitysystem.comments.Comment;
import com.example.communitysystem.community.Community;
import lombok.*;
import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private Long authorId;

    private String title;
    private String content;

    private ZonedDateTime timeStamp;

    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    @OptimisticLock(excluded = true)
    private List<Comment> comments;

    @ManyToOne
    private Community community;

    @OneToOne(mappedBy = "post")
    private PostScore postScore;

    @Version
    private Long version;

    public void addComment(Comment comment) { this.comments.add(comment); }
    public void deleteComment(Comment comment) { this.comments.remove(comment); }
    public void changeContent(String content) {
        setContent(content);
    }
    public void changeTitle(String title) { setTitle(title); }
    public void uploadImage(byte[] image) { setImage(image); }
}
