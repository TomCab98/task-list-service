package com.projects.taskmanager.user.infrastructure.repositories.entities;

import com.projects.taskmanager.user.infrastructure.dtos.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "`roles`")
public class RoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "role_name")
  @Enumerated(EnumType.STRING)
  private RoleEnum role;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "role_permissions",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id")
  )
  private Set<PermissionEntity> permissionList = new HashSet<>();
}
