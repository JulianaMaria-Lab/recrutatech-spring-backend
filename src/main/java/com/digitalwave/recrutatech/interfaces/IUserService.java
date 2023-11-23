package com.digitalwave.recrutatech.interfaces;

import java.util.List;

import com.digitalwave.recrutatech.entity.Usuario;

public interface IUserService {
  Usuario createUser(Usuario user);
  List<Usuario> getAllUsers();
  Usuario getById(Long id);
  Usuario updateUser(Long id, Usuario updatedUser);
  Usuario deleteUser(Long id);
}
