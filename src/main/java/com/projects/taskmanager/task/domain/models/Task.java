package com.projects.taskmanager.task.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  private Long id;
  private String name;
  private String description;
  private LocalDate creationDate;
  private LocalDate reminderDate;
  private boolean reminder;
  private String userEmail;
}
