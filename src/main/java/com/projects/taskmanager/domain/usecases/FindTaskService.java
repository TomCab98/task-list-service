package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.models.Task;

import java.util.List;

public class FindTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public FindTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public List<Task> findAll() {
    try {
      return repositoryAdapter.getAllTasks();
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining tasks from database");
    }

  }
}
