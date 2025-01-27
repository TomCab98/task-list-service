package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.models.Task;

public class UpdateTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public UpdateTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public Task update(String id, Task task) {
    return repositoryAdapter.updateTask(id, task);
  }
}
