package com.projects.taskmanager.task.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.FindService;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;

public class FindTaskService extends FindService<Task, String> {

  public FindTaskService(ITaskRepositoryPort repository) {
    super(repository);
  }
}
