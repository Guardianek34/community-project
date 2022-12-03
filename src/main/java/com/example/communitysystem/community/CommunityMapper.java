package com.example.communitysystem.community;

import com.example.communitysystem.community.dto.CommunitySummary;
import com.example.communitysystem.user.UserProfile;

import java.util.List;
import java.util.stream.Collectors;

class CommunityMapper {
    public static Community mapToCommunity(String communityName, UserProfile user) {
        return Community.builder()
                .name(communityName)
                .creator(user)
                .build();
    }

    public static CommunitySummary mapToSummary(Community community) {
        return CommunitySummary.builder()
                .id(community.getId())
                .name(community.getName())
                .title(community.getTitle())
                .description(community.getDescription())
                .rules(community.getRules())
                .creatorUsername(community.getCreatorName())
                .build();
    }

    public static List<CommunitySummary> mapToSummaries(List<Community> communities) {
        return communities.stream()
                .map(CommunityMapper::mapToSummary)
                .collect(Collectors.toList());
    }
}
