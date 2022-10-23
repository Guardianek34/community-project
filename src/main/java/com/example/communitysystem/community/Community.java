package com.example.communitysystem.community;

import com.example.communitysystem.users.User;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class Community {
    @Id
    private UUID CommunityId;

    @OneToMany(mappedBy = "community")
    private List<Post> posts;

    @OneToOne
    private User communityAuthor;

    @ManyToMany
    private Set<User> subscribers;

    private void addSubscriber(User user){
        this.subscribers.add(user);
        user.getSubscribedCommunities().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Community community = (Community) o;
        return  Objects.equals(CommunityId, community.CommunityId) &&
                Objects.equals(posts, community.posts) &&
                Objects.equals(communityAuthor, community.communityAuthor) &&
                Objects.equals(subscribers, community.subscribers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CommunityId, posts, communityAuthor, subscribers);
    }
}