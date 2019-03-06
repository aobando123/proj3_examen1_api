package com.cenfotec.examen.post.post.repositories;

import com.cenfotec.examen.post.post.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
