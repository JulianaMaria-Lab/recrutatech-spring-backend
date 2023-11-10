package com.digitalwave.recrutatech.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  User user = userService.findByEmail(userEmail);

    if (user != null) {
      String reset_password_token = UUID.randomUUID().toString();
      Instant currentTimestamp = Instant.now();
      Timestamp timestamp = Timestamp.from(currentTimestamp);

      user.setResetPasswordToken(reset_password_token);
      user.setTokenCreatedAt(timestamp);
      user.setTokenUpdatedAt(timestamp);

      userService.updateUser(user.getId(), user);
      
      return new ResponseEntity<>(user, HttpStatus.OK);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/find-by-reset-password-token")
  public ResponseEntity<?> findUserByResetPasswordToken(@RequestBody Map<String, String> requestBody) {
    String resetPasswordToken = requestBody.get("resetPAsswordToken");

    if (resetPasswordToken != null && !resetPasswordToken.isEmpty()) {
      User user = userService.findByResetPasswordToken(resetPasswordToken);

      if (user != null) {
        return new ResponseEntity<>(user, HttpStatus.OK);
      } else {
        return ResponseEntity.notFound().build();
      }
    } else {
      return ResponseEntity.badRequest().body("O token de redefinição de senha não pode ser nulo ou vazio.");
    }
  }
}
