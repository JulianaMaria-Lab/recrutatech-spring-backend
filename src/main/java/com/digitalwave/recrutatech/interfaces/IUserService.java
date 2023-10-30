package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.User;

public interface IUserService {
  User createUser(User user);
  List<User> getAllUsers();
  User getById(Long id);
  User updateUser(Long id, User updatedUser);
  User deleteUser(Long id);
  void resetPassword(String userEmail, String newPassword);
}
