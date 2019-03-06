package com.cenfotec.examen.post.post.services;

import com.cenfotec.examen.post.post.domain.Comment;
import com.cenfotec.examen.post.post.domain.Post;
import com.cenfotec.examen.post.post.domain.Tag;
import com.cenfotec.examen.post.post.domain.User;
import com.cenfotec.examen.post.post.repositories.PostRepository;
import com.cenfotec.examen.post.post.repositories.TagRepository;
import com.cenfotec.examen.post.post.repositories.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, TagRepository tagRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
    }

    public List<Post> findAllRecentPost() {
        return postRepository.findAll(new Sort(Sort.Direction.DESC, "timestamp"));
    }

    public Post findById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return optionalPost.get();
        }
        return null;
    }

    public List<Post> findByPreferences(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<Tag> tagList = new ArrayList<Tag>();
            tagList.addAll(user.get().getPreferences());
            return postRepository.findByTagsInOrderByIdDesc(tagList);
        }
        return new ArrayList<>();

    }

    public List<Post> findUserPost(Long userId) {
        return postRepository.findByOwnerIdOrderByIdDesc(userId);
    }

    public List<Post> findLikedPosts(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return postRepository.findByLikesInOrderByIdDesc(user.get());
        }
        return new ArrayList<>();
    }

    public Post createNewPost(Post post) {
        List<Tag> tagList = tagRepository.saveAll(post.getTags());
        post.setTags(new HashSet<>(tagList));
        return postRepository.save(post);
    }

    public Post updateLikesPost(List<User> userList, Long id) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setLikes(userList);
            return this.postRepository.save(post);
        }
        return null;
    }

    public Post addComments(Comment comment, Long id) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.getComments().add(comment);
            return this.postRepository.save(post);
        }
        return null;
    }
}
