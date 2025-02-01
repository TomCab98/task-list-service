package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskRepositoryPort;

public class DeleteTaskService {
  private final ITaskRepositoryPort<Task> repository;
  private final FindTaskService findTaskService;

  public DeleteTaskService(ITaskRepositoryPort<Task> repository, FindTaskService findTaskService) {
    this.repository = repository;
    this.findTaskService = findTaskService;
  }

  public void delete(String id) {
    if (!findTaskService.existById(id)) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    try {
      this.repository.delete(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail deleting the task from database " + id);
    }

  }
}
