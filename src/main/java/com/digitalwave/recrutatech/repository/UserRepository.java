package com.digitalwave.recrutatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.digitalwave.recrutatech.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUserEmail(String userEmail);
}