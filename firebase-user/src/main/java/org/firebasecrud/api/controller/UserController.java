package org.firebasecrud.api.controller;

import org.firebasecrud.api.model.User;
import org.firebasecrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController
{
    public UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws ExecutionException, InterruptedException
    {
        return userService.createUser(user);
    }

    @GetMapping("/get")
    public User getUser(@RequestParam String id) throws ExecutionException, InterruptedException
    {
        return userService.getUser(id);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) throws ExecutionException, InterruptedException
    {
        return userService.updateUser(user);
    }

    @PutMapping("/delete")
    public String removeUser(@RequestParam String id)
    {
        return userService.removeUser(id);
    }

    // === for browser ===
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {return ResponseEntity.ok("Test Get endpoint is working");}
}
