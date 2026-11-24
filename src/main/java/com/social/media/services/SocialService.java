package com.social.media.services;

import com.social.media.models.SocialUser;
import com.social.media.repositories.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    SocialUserRepository userRepository;

    public SocialService(SocialUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<SocialUser> getAllUsers() {
        return userRepository.findAll();
    }

    public SocialUser saveUser(SocialUser user) {
        return userRepository.save(user);
    }

    public SocialUser deleteUser(Long userId) {
        SocialUser socialUser = userRepository.findById(userId)
                .orElseThrow( () -> new RuntimeException("Usernot found"));

        userRepository.delete(socialUser);
        return socialUser;

    }
}
