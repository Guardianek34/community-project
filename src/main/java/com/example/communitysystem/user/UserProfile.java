package com.example.communitysystem.user;

import com.example.communitysystem.community.Community;
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
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String userImageUrl;

    @ManyToMany
    @JoinTable(
        name = "community_subscribers",
        joinColumns = @JoinColumn(name = "community_id"),
        inverseJoinColumns = @JoinColumn(name = "user_profile_id")
    )
    private Set<Community> subscribedCommunities;
}
