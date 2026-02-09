package com.projects.taskmanager.task.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.UpdateService;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;

public class UpdateTaskService extends UpdateService<Task, Long> {

  public UpdateTaskService(ITaskRepositoryPort repository) {
    super(repository);
  }
}
