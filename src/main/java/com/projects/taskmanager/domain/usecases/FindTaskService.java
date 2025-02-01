package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class FindTaskService {
  private final ITaskRepositoryPort<Task> repository;

  public FindTaskService(ITaskRepositoryPort<Task> repository) {
    this.repository = repository;
  }

  public List<Task> findAll() {
    try {
      return this.repository.getAll();
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining tasks from database");
    }
  }

  public Task findById(String id) {
    Optional<Task> task;
    try {
      task = this.repository.findById(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining task with id from database");
    }

    if (task.isEmpty()) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    return task.get();
  }

  public boolean existById(String id) {
    Optional<Task> task = this.repository.findById(id);
    return task.isPresent();
  }
}
