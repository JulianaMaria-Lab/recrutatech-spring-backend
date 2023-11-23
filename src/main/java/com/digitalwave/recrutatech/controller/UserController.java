package com.digitalwave.recrutatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.digitalwave.recrutatech.entity.Usuario;
import com.digitalwave.recrutatech.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
    Usuario createdUser = userService.createUser(user);
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Usuario>> getAllUsers() {
    List<Usuario> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
    Usuario user = userService.getById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Usuario> updateJob(@PathVariable("id") long id, @RequestBody Usuario updatedUser) {
    Usuario updatedUserEntity = userService.updateUser(id, updatedUser);
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
}
