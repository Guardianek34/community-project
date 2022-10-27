package com.example.communitysystem.user;


import javax.persistence.Embeddable;

@Embeddable
public class UserDetails {
    // TODO all of these fields should be validated in DTO
    private String name;
    private String email;
    private String userImageUrl;
}
