package com.cenfotec.examen.post.post.domain;

import com.cenfotec.examen.post.post.enums.Status;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Tag> preferences = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Tag> getPreferences() {
        return preferences;
    }

    public void setPreferences(Set<Tag> preferences) {
        this.preferences = preferences;
    }


}
