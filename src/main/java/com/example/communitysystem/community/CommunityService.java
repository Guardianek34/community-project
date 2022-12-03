package com.example.communitysystem.community;

import com.example.communitysystem.community.exception.CommunityNameNotUniqueException;
import com.example.communitysystem.user.UserProfile;
import com.example.communitysystem.user.UserRepository;
import com.example.communitysystem.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static com.example.communitysystem.community.CommunityMapper.mapToCommunity;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final UserRepository userRepository;

    public Community createCommunity(String communityName, String username) {
        if (this.communityRepository.existsByName(communityName)) {
            throw new CommunityNameNotUniqueException();
        }

        UserProfile user = this.userRepository.findByName(username)
                .orElseThrow(UserNotFoundException::new);

        return this.communityRepository.save(mapToCommunity(communityName, user));
    }

    public Community getCommunity(long id) {
        return this.communityRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public boolean doesCommunityExists(String name) {
        return this.communityRepository.existsByName(name);
    }

    public List<Community> getCommunities() {
        return this.communityRepository.findAll();
    }
}
