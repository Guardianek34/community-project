package com.example.communitysystem.auth;

import com.example.communitysystem.community.Community;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @ManyToOne
    private Community community;

    @ManyToMany(mappedBy = "roles")
    private Set<UserAuth> users;
}
