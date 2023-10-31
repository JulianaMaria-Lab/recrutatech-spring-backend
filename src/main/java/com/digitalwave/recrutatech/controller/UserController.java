package com.digitalwave.recrutatech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.digitalwave.recrutatech.entity.User;
import com.digitalwave.recrutatech.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    User user = userService.getById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateJob(@PathVariable("id") long id, @RequestBody User updatedUser) {
    User updatedUserEntity = userService.updateUser(id, updatedUser);
    if (updatedUserEntity != null) {
      return ResponseEntity.ok(updatedUserEntity);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/find-by-email")
  public ResponseEntity<User> findUserByEmail(@RequestBody Map<String, String> requestBody) {
  String userEmail = requestBody.get("userEmail");
  System.out.println("-------------");
  System.out.println(userEmail);
  User user = userService.findByEmail(userEmail);
  System.out.println("-------------");
  System.out.println(user);
  if (user != null) {
    return new ResponseEntity<>(user, HttpStatus.OK);
  } else {
    return ResponseEntity.notFound().build();
  }
  }
}
