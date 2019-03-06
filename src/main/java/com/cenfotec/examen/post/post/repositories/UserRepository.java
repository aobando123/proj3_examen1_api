package com.cenfotec.examen.post.post.repositories;

import com.cenfotec.examen.post.post.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByNickname(String nickname);
}
