package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;

public class DeleteTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public DeleteTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public void delete(String id) {
    try {
      repositoryAdapter.deleteTask(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail deleting the task from database " + id);
    }

  }
}
