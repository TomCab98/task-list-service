package com.projects.taskmanager.user.infrastructure.dtos;

import com.projects.taskmanager.user.infrastructure.dtos.validators.ValidateRoleList;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
  private String id;

  @NotBlank(message = "The username cannot be blank")
  @Size(max = 100, min = 3, message = "The username cannot be longer than 100 characters and less than 3 characters.")
  private String username;

  @NotNull(message = "The date cannot be null")
  @Size(max = 100, min = 3, message = "Password not valid")
  private String password;

  @NotNull(message = "The password cannot be null")
  @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Not valid email")
  private String email;

  @NotEmpty(message = "Must be at least one rol")
  @Size(min = 1, message = "Must be at least one rol")
  @ValidateRoleList
  private List<String> roles;
}

