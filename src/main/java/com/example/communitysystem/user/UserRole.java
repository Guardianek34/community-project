package com.example.communitysystem.user;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    private Long communityId;
}
