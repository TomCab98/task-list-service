package com.projects.taskmanager.domain.exceptions;

public class TicketNotFoundException extends ExceptionManager {
  public TicketNotFoundException(String message) {
    super(message);
  }
}
