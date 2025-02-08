package com.projects.taskmanager.tasks.domain.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Task {
  private String id;
  private String name;
  private LocalDate date;
  private boolean reminder;

  public boolean getReminder() {
    return this.reminder;
  }
}
