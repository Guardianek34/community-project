package com.example.communitysystem.posts;

import com.example.communitysystem.auth.UserAuth;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostScore {

    private static final Integer ZERO = 0;
    private static final Integer HIDDEN_THRESHOLD_VALUE = -100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private UserAuth user;

    private Integer scoreValue = ZERO;

    public void likePost() { this.scoreValue = 1;}
    public void dislikePost() { this.scoreValue = -1;}
}
