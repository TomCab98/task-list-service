package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class FindTaskService {
  private final ITaskRepositoryPort<Task> repositoryAdapter;

  public FindTaskService(ITaskRepositoryPort<Task> repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public List<Task> findAll() {
    try {
      return this.repositoryAdapter.getAll();
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining tasks from database");
    }
  }

  public Task findById(String id) {
    Optional<Task> task;
    try {
      task = this.repositoryAdapter.findById(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining task with id from database");
    }

    if (task.isEmpty()) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    return task.get();
  }
}
