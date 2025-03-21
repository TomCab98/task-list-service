package com.projects.taskmanager.task.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.DeleteService;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;

public class DeleteTaskService extends DeleteService<Task, String> {

  public DeleteTaskService(ITaskRepositoryPort repository, FindTaskService findService) {
    super(repository, findService);
  }
}
