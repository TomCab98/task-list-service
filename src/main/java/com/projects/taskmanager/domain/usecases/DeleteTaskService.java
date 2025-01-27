package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;

public class DeleteTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public DeleteTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public void delete(String id) {
    repositoryAdapter.deleteTask(id);
  }
}
