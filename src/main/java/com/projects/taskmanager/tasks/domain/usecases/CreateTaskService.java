package com.projects.taskmanager.tasks.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.domain.ports.ITaskRepositoryPort;

public class CreateTaskService extends CreateService<Task, String> {

  public CreateTaskService(ITaskRepositoryPort repository) {
    super(repository);
  }
}
