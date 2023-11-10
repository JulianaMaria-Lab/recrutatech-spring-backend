package com.digitalwave.recrutatech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")

public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private long id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "user_password")
  //@JsonIgnore
  private String userPassword;

  @Column(name = "user_role")
  private String userRole;

  @Column(name = "user_status")
  private Boolean userStatus;

  @Column(name = "created_at")
  private java.sql.Timestamp createdAt;

  @Column(name = "updated_at")
  private java.sql.Timestamp updatedAt;

  @Column(name = "reset_password_token")
  private String resetPasswordToken;

  @Column(name = "token_created_at")
  private java.sql.Timestamp TokenCreatedAt;

  @Column(name = "token_updated_at")
  private java.sql.Timestamp TokenUpdatedAt;

  public long getId() {
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

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
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

  public String getResetPasswordToken() {
    return resetPasswordToken;
  }

  public void setResetPasswordToken(String resetPasswordToken) {
    this.resetPasswordToken = resetPasswordToken;
  }

  public java.sql.Timestamp getTokenCreatedAt() {
    return TokenCreatedAt;
  }

  public void setTokenCreatedAt(java.sql.Timestamp tokenCreatedAt) {
    TokenCreatedAt = tokenCreatedAt;
  }

  public java.sql.Timestamp getTokenUpdatedAt() {
    return TokenUpdatedAt;
  }

  public void setTokenUpdatedAt(java.sql.Timestamp tokenUpdatedAt) {
    TokenUpdatedAt = tokenUpdatedAt;
  }
}
