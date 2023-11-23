package com.digitalwave.recrutatech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usr_usuario")
public class Usuario {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_password")
  //@JsonIgnore
  private String password;

  @Column(name = "user_role")
  private String userRole;

  @Column(name = "user_status")
  private Boolean userStatus;

  @Column(name = "created_at")
  private java.sql.Timestamp createdAt;

  @Column(name = "updated_at")
  private java.sql.Timestamp updatedAt;

  public Usuario() {
  }

  public Usuario(String email, String password, String userName) {
    this.email = email;
    this.password = password;
    this.userName = userName;
  }

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public Boolean getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Boolean userStatus) {
      this.userStatus = userStatus;
  }

  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

}