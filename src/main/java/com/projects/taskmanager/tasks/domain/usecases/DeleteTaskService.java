package com.projects.taskmanager.tasks.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.DeleteService;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.domain.ports.ITaskRepositoryPort;

public class DeleteTaskService extends DeleteService<Task, String> {

  public DeleteTaskService(ITaskRepositoryPort repository, FindTaskService findService) {
    super(repository, findService);
  }
}
