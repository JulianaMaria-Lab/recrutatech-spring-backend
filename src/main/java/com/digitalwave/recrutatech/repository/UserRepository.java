package com.digitalwave.recrutatech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalwave.recrutatech.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByEmail(String email);
}