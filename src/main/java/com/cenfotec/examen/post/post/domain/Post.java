package com.cenfotec.examen.post.post.domain;

import com.cenfotec.examen.post.post.enums.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String text;
    private Status status;
    private String image;
    private Timestamp timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "post_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likes;

    @OneToMany(cascade = CascadeType.ALL)
    @OrderBy("id")
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "post_tags",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getText() {
        return text;
    }

    public void setText(java.lang.String text) {
        this.text = text;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public java.lang.String getImage() {
        return image;
    }

    public void setImage(java.lang.String image) {
        this.image = image;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public User getUser() {
        return owner;
    }

    public void setUser(User owner) {
        this.owner = owner;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }
}