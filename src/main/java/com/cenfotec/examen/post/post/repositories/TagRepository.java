package com.cenfotec.examen.post.post.repositories;

import com.cenfotec.examen.post.post.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    public List<Tag> findByNameLike(String name);
}
