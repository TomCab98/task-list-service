package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.models.Task;

import java.util.List;

public class FindTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public FindTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public List<Task> findAll() {
    return repositoryAdapter.getAllTasks();
  }
}
