package com.projects.taskmanager.task.adapters.repositories;

import com.projects.taskmanager.core.adapters.repositories.RepositoryAdapter;
import com.projects.taskmanager.task.adapters.mappers.TaskRepositoryMapper;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;
import com.projects.taskmanager.task.infrastructure.repositories.TaskRepository;
import com.projects.taskmanager.task.infrastructure.repositories.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskRepositoryAdapter extends RepositoryAdapter<Task, TaskEntity, String> implements ITaskRepositoryPort {

  public TaskRepositoryAdapter(TaskRepository repository, TaskRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
