package com.projects.taskmanager.user.domain.models;

import lombok.Data;

@Data
public class User {
  private String id;
  private String name;
  private String password;
  private String email;
}
