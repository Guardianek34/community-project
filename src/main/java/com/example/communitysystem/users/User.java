package com.example.communitysystem.users;

import com.example.communitysystem.community.Community;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class User {
    @Id
    private UUID UserId;

    @ManyToMany
    private Set<Community> subscribedCommunities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(UserId, user.UserId) && Objects.equals(subscribedCommunities, user.subscribedCommunities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, subscribedCommunities);
    }
}
