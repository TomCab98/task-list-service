package com.projects.taskmanager.tasks.domain.exceptions;

public class DatabaseAccessException extends ExceptionManager {
  public DatabaseAccessException(String message) {
    super(message);
  }
}
