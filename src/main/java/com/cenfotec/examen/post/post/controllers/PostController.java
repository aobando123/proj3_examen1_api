package com.cenfotec.examen.post.post.controllers;

import com.cenfotec.examen.post.post.domain.Comment;
import com.cenfotec.examen.post.post.domain.Post;
import com.cenfotec.examen.post.post.domain.User;
import com.cenfotec.examen.post.post.enums.Status;
import com.cenfotec.examen.post.post.imageHandler.CloudinaryUtil;
import com.cenfotec.examen.post.post.services.PostService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<Post> getAllPost() {
        return postService.findAllRecentPost();
    }

    @GetMapping("/{id}")
    public Post findPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping()
    public Post createPost(@RequestBody Post post) throws IOException {
        Cloudinary imageUpload = CloudinaryUtil.getCloudinaryInstance();
        Map uploadResult = imageUpload.uploader().upload(post.getImage(), ObjectUtils.emptyMap());
        post.setImage(uploadResult.get("url").toString());
        post.setStatus(Status.ACTIVE);
        return postService.createNewPost(post);
    }

    @GetMapping("/user/{id}")
    public List<Post> getPostByUser(@PathVariable Long id) {
        return postService.findUserPost(id);
    }

    @GetMapping("/preference/{id}")
    public List<Post> getPostByTags(@PathVariable Long id) {
        return postService.findByPreferences(id);
    }

    @GetMapping("/liked/{id}")
    public List<Post> getLikedPost(@PathVariable Long id) {
        return postService.findLikedPosts(id);
    }

    @PutMapping("/like/{Id}")
    public Post updateLikes(@RequestBody List<User> userLikes, @PathVariable Long Id) {
        return postService.updateLikesPost(userLikes, Id);
    }

    @PostMapping("/comment/{Id}")
    public Post updateLikes(@RequestBody Comment postComment, @PathVariable Long Id) {
        return postService.addComments(postComment, Id);
    }


}
