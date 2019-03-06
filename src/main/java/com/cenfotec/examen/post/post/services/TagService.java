package com.cenfotec.examen.post.post.services;

import com.cenfotec.examen.post.post.domain.Tag;
import com.cenfotec.examen.post.post.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTagList() {
        return tagRepository.findAll();
    }
}
