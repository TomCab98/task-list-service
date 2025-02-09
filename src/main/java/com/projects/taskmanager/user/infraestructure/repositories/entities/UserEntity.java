package com.projects.taskmanager.user.infraestructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`user`")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
  private String password;
  private String email;
}
