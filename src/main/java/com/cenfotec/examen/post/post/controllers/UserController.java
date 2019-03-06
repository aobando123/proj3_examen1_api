package com.cenfotec.examen.post.post.controllers;


import com.cenfotec.examen.post.post.domain.User;
import com.cenfotec.examen.post.post.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/nickname/{nickname}")
    public User findUserByNickname(@PathVariable String nickname) {
        return userService.findUser(nickname);
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
