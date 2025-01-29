package com.sconexsoft.ecom.controller;

import com.sconexsoft.ecom.entity.EcomUser ;
import com.sconexsoft.ecom.service.EcomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class EcomUserController {

    @Autowired
    private EcomUserService userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<EcomUser >> getAllUsers() {
        List<EcomUser > users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<EcomUser > getUserById(@PathVariable int id) {
        Optional<EcomUser > user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Add a new user
    @PostMapping
    public ResponseEntity<EcomUser > createUser (@RequestBody EcomUser  user) {
        EcomUser  createdUser  = userService.addUser (user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser );
    }

    // Update a user
    @PutMapping("/{id}")
    public ResponseEntity<EcomUser > updateUser (@PathVariable int id, @RequestBody EcomUser  user) {
        if (!userService.getUserById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        user.setUserId(id); // Ensure the user ID matches the path variable
        EcomUser  updatedUser  = userService.updateUser (user);
        return ResponseEntity.ok(updatedUser );
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable int id) {
        if (userService.deleteUser (id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}