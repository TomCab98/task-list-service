package com.projects.taskmanager.domain.exceptions;

public class DatabaseAccessException extends ExceptionManager {
  public DatabaseAccessException(String message) {
    super(message);
  }
}
