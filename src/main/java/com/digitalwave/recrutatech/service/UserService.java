package com.digitalwave.recrutatech.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.digitalwave.recrutatech.entity.User;
import com.digitalwave.recrutatech.interfaces.IUserService;
import com.digitalwave.recrutatech.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepo;

  private BCryptPasswordEncoder passwordEncoder;

  @Transactional
  public User createUser(User user) {
    validateUser(user);

    // Criptografa a senha usando BCrypt
    passwordEncoder = new BCryptPasswordEncoder();
    String hashedPassword = passwordEncoder.encode(user.getpassword());
    user.setpassword(hashedPassword);
    
    user.setUserStatus(true); // Defina o status como true por padrão
    user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    return userRepo.save(user);
  }

  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  public User getById(Long id) {
    return userRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado - ID: " + id));
  }

  @Transactional
  public User updateUser(Long id, User updatedUser) {
    User existingUser = userRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado - ID: " + id));

    // Atualize os campos do usuário existente conforme necessário
    if (!ObjectUtils.isEmpty(updatedUser.getUserName())) {
        existingUser.setUserName(updatedUser.getUserName());
    }
    if (!ObjectUtils.isEmpty(updatedUser.getemail())) {
        existingUser.setemail(updatedUser.getemail());
    }
    if (!ObjectUtils.isEmpty(updatedUser.getUserRole())) {
        existingUser.setUserRole(updatedUser.getUserRole());
    }
    if (!ObjectUtils.isEmpty(updatedUser.getUserStatus())) {
        existingUser.setUserStatus(updatedUser.getUserStatus());
    }

    existingUser.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    return userRepo.save(existingUser);
  }

  @Transactional
  public User deleteUser(Long id) {
    User user = userRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado - ID: " + id));

    userRepo.deleteById(id);
    return user;
  }

  private void validateUser(User user) {
    if (user == null || 
        isNullOrBlank(user.getUserName()) || 
        isNullOrBlank(user.getemail()) || 
        isNullOrBlank(user.getpassword())) {
      throw new IllegalArgumentException("Dados inválidos!");
    }
  }

  private boolean isNullOrBlank(String value) {
    return value == null || value.trim().isEmpty();
  }
}
