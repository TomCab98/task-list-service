package com.projects.taskmanager.task.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Task {
  private String id;
  private String name;
  private LocalDate date;
  private boolean reminder;
  private String userEmail;

  public boolean getReminder() {
    return this.reminder;
  }
}
