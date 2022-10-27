package com.example.communitysystem.community;

import com.example.communitysystem.posts.Post;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue
    private Long id;

    private Long authorId;

    private String urlName;
    private String title;
    private String description;

    @ElementCollection
    private List<Rule> rules;

    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    @Version
    private Long version;

}
