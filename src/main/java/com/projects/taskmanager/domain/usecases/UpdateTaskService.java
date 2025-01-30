package com.projects.taskmanager.domain.usecases;

import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.exceptions.IllegalArgumentException;
import com.projects.taskmanager.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.domain.models.Task;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

public class UpdateTaskService {
  private final TaskRepositoryAdapter repositoryAdapter;

  public UpdateTaskService(TaskRepositoryAdapter repositoryAdapter) {
    this.repositoryAdapter = repositoryAdapter;
  }

  public Task update(String id, Task criteria) {
    Optional<Task> existTask = this.repositoryAdapter.findById(id);
    if (existTask.isEmpty()) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    Task task = existTask.get();
    for (Field field : Task.class.getDeclaredFields()) {
      field.setAccessible(true);

      try {
        Object newValue = field.get(criteria);
        Object oldValue = field.get(task);

        if (newValue != null && !Objects.equals(newValue, oldValue)) {
          field.set(task, newValue);
        }
      } catch (Exception e) {
        throw new IllegalArgumentException("Error updating task field: " + field.getName() + e);
      }
    }

    return this.repositoryAdapter.create(task);
  }
}
