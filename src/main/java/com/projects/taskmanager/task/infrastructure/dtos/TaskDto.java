package com.projects.taskmanager.task.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {

  private Long id;
  private boolean reminder;
  private LocalDate reminderDate;

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The name cannot be longer than 100 characters and less than 3 characters.")
  private String name;

  @Size(max = 300, message = "Description cannot be longer than 300 characters")
  private String description;

  @NotNull(message = "The date cannot be null")
  private LocalDate creationDate;

  @Null
  private String userEmail;
}