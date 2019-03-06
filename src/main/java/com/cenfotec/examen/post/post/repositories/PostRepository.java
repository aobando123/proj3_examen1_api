package com.cenfotec.examen.post.post.repositories;

import com.cenfotec.examen.post.post.domain.Post;
import com.cenfotec.examen.post.post.domain.Tag;
import com.cenfotec.examen.post.post.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    public List<Post> findByOwnerIdOrderByIdDesc(Long userId);

    public List<Post> findByTagsInOrderByIdDesc(List<Tag> tags);

    public List<Post> findByLikesInOrderByIdDesc(User user);
}
