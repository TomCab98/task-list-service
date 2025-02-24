package com.projects.taskmanager.user.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "`users`")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  private String password;

  @Column(unique = true)
  private String username;

  @Column(unique = true)
  private String email;

  @Column(name = "is_enable")
  private boolean isEnabled;

  @Column(name = "account_no_expired")
  private boolean accountNoExpired;

  @Column(name = "account_no_locked")
  private boolean accountNoLocked;

  @Column(name = "credentials_no_expired")
  private boolean credentialsNoExpired;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<RoleEntity> roles = new HashSet<>();
}
