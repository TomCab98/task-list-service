package com.projects.taskmanager.user.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
  private Long id;
  private String name;
  private String password;
  private String email;
  private List<String> roles;
}
