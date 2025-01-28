package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskServicePort;

public class CreateTaskService {
  private final ITaskServicePort<Task> repositoryAdapter;

  public CreateTaskService(ITaskServicePort<Task> repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public Task create(Task task) {
    try {
      return repositoryAdapter.createTask(task);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail saving task in database " + task.toString());
    }
  }
}
