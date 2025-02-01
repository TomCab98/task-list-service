package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskRepositoryPort;

public class CreateTaskService {
  private final ITaskRepositoryPort<Task> repository;

  public CreateTaskService(ITaskRepositoryPort<Task> repository) {
    this.repository = repository;
  }

  public Task create(Task task) {
    try {
      return repository.create(task);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail saving task in database " + task.toString());
    }
  }
}
