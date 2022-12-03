package com.example.communitysystem.community;

import com.example.communitysystem.community.dto.CommunitySummary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.example.communitysystem.community.CommunityMapper.mapToSummaries;
import static com.example.communitysystem.community.CommunityMapper.mapToSummary;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @PostMapping("/{name}")
    public Community createNewCommunity(@PathVariable String name,
                                        Principal principal) {
        String username = principal.getName();
        return communityService.createCommunity(name, username);
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/{name}")
    public ResponseEntity<?> doesCommunityExistsWithName(@PathVariable String name) {
        boolean communityExists = communityService.doesCommunityExists(name);

        if(communityExists) return ResponseEntity.status(HttpStatus.CONFLICT).build();
        else return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public CommunitySummary fetchOneById(@PathVariable long id) {
        return mapToSummary(communityService.getCommunity(id));
    }

    @GetMapping
    public List<CommunitySummary> fetchAll() {
        return mapToSummaries(communityService.getCommunities());
    }
}
