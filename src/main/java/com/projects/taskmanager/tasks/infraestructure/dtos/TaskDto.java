package com.projects.taskmanager.tasks.infraestructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskDto {
  private String id;

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The name cannot be longer than 100 characters and less than 3 characters.")
  private String name;

  @NotNull(message = "The date cannot be null")
  @Pattern(
    regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$", message = "Date must be in format 'dd-MM-yyyy'"
  )
  private String date;

  private boolean reminder;
}