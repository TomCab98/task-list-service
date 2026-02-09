package com.projects.taskmanager.task.domain.usecases;

import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;

import java.time.LocalDate;

public class CreateTaskService extends CreateService<Task, Long> {

  public CreateTaskService(ITaskRepositoryPort repository) {
    super(repository);
  }

  @Override
  public Task create(Task model) {
    if (model.getDate() == null) {
      model.setDate(LocalDate.now());
    }

    return super.create(model);
  }
}
