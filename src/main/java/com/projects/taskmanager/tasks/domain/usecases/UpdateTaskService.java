package com.projects.taskmanager.tasks.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.UpdateService;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.domain.ports.ITaskRepositoryPort;

public class UpdateTaskService extends UpdateService<Task, String> {

  public UpdateTaskService(ITaskRepositoryPort repository) {
    super(repository);
  }
}
