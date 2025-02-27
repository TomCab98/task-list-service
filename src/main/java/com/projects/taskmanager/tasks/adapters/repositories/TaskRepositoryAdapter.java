package com.projects.taskmanager.tasks.adapters.repositories;

import com.projects.taskmanager.core.adapters.repositories.RepositoryAdapter;
import com.projects.taskmanager.tasks.adapters.mappers.TaskRepositoryMapper;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.domain.ports.ITaskRepositoryPort;
import com.projects.taskmanager.tasks.infrastructure.repositories.TaskRepository;
import com.projects.taskmanager.tasks.infrastructure.repositories.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskRepositoryAdapter extends RepositoryAdapter<Task, TaskEntity, String> implements ITaskRepositoryPort {

  public TaskRepositoryAdapter(TaskRepository repository, TaskRepositoryMapper mapper) {
    super(repository, mapper);
  }
}
