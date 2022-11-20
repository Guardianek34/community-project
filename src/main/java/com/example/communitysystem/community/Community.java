package com.example.communitysystem.community;

import com.example.communitysystem.posts.Post;
import com.example.communitysystem.user.UserProfile;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;
    private String description;

    @ElementCollection
    private List<Rule> rules;

    @ManyToOne
    private UserProfile creator;

    @ManyToMany(mappedBy = "subscribedCommunities")
    private Set<UserProfile> subscribers;

    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    @Version
    private Long version;

}
