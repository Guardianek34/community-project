package com.example.communitysystem.community;

import com.example.communitysystem.auth.UserAuth;
import com.example.communitysystem.posts.Post;
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
    private UserAuth creator;

    @ManyToMany(mappedBy = "subscribedCommunities")
    private Set<UserAuth> subscribers;

    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    @Version
    private Long version;

    public String getCreatorName() {
        return this.creator.getUsername();
    }



}
