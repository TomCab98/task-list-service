package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskServicePort;

import java.util.List;

public class FindTaskService {
  private final ITaskServicePort<Task> repositoryAdapter;

  public FindTaskService(ITaskServicePort<Task> repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public List<Task> findAll() {
    try {
      return this.repositoryAdapter.getAllTasks();
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining tasks from database");
    }
  }

  public Task findById(String id) {
    try {
      return this.repositoryAdapter.findById(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining task with id from database");
    }
  }
}
