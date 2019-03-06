package com.cenfotec.examen.post.post.services;

import com.cenfotec.examen.post.post.domain.Tag;
import com.cenfotec.examen.post.post.domain.User;
import com.cenfotec.examen.post.post.enums.Status;
import com.cenfotec.examen.post.post.repositories.TagRepository;
import com.cenfotec.examen.post.post.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final TagRepository tagRepository;

    public UserService(UserRepository userRepository, TagRepository tagRepository) {
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional(readOnly = true)
    public User findUser(String nickname) {
        Optional<User> isUser = userRepository.findByNickname(nickname);
        return isUser.orElse(null);
    }

    public User createUser(User user) {
        user.setStatus(Status.ACTIVE);
        Optional<User> isUser = userRepository.findByNickname(user.getNickname());
        if (isUser.isPresent()) {
            return null;
        }
        List<Tag> tagList = tagRepository.saveAll(user.getPreferences());
        user.setPreferences(new HashSet<>(tagList));
        return userRepository.save(user);
    }

}
