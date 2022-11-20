package com.example.communitysystem.community;

import com.example.communitysystem.community.exception.NameNotUniqueException;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;

    public Community createNewCommunity(String communityName) {
        if (this.communityRepository.existsByName(communityName)) {
            throw new NameNotUniqueException();
        }
        throw new NotYetImplementedException();
        // TODO: Implement adding taking into consideration uniqueness.
    }
}
