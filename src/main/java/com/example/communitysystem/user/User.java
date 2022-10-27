package com.example.communitysystem.user;

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
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @ElementCollection
    private List<Long> subscribedCommunities;

    @Embedded
    private UserDetails userDetails;

    @ManyToMany
    private Set<UserRole> roles;
}
