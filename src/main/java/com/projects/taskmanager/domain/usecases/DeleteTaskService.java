package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.domain.models.Task;

import java.util.Optional;

public class DeleteTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public DeleteTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public void delete(String id) {
    Optional<Task> task = this.repositoryAdapter.findById(id);
    if (task.isEmpty()) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }
    
    try {
      this.repositoryAdapter.delete(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail deleting the task from database " + id);
    }

  }
}
