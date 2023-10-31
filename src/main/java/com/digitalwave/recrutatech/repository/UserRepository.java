package com.digitalwave.recrutatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.digitalwave.recrutatech.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByUserEmail(String userEmail);
}