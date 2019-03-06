package com.cenfotec.examen.post.post.controllers;

import com.cenfotec.examen.post.post.domain.Tag;
import com.cenfotec.examen.post.post.services.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping()
    public List<Tag> getTagLikeName() {
        return this.tagService.getTagList();
    }

}
