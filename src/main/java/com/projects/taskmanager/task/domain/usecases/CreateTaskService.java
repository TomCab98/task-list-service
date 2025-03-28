package com.projects.taskmanager.task.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;

public class CreateTaskService extends CreateService<Task, String> {

  public CreateTaskService(ITaskRepositoryPort repository) {
    super(repository);
  }
}
