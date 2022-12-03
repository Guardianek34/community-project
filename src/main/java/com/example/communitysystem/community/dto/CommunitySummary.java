package com.example.communitysystem.community.dto;

import com.example.communitysystem.community.Rule;
import lombok.Builder;

import java.util.List;

public record CommunitySummary(
        Long id,
        String name,
        String title,
        String description,
        List<Rule> rules,
        String creatorUsername) {
    @Builder public CommunitySummary {}
}
