package com.projects.taskmanager.domain.exceptions;

public class ExceptionManager extends RuntimeException {
  public ExceptionManager(String message) {
    super(message);
  }

  public String getClassName() {
    return this.getClass().getName();
  }
}
