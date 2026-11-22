package com.social.media.models;


import jakarta.persistence.*;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialProfile")
    //@JoinColumn(name = "social_user")
    private User user;

}
