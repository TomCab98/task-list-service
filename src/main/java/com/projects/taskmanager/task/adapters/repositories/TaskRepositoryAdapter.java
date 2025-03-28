package com.projects.taskmanager.task.adapters.repositories;

import com.projects.taskmanager.core.adapters.repositories.RepositoryAdapter;
import com.projects.taskmanager.task.adapters.mappers.TaskRepositoryMapper;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskRepositoryPort;
import com.projects.taskmanager.task.infrastructure.repositories.TaskRepository;
import com.projects.taskmanager.task.infrastructure.repositories.entities.TaskEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryAdapter extends RepositoryAdapter<Task, TaskEntity, String> implements ITaskRepositoryPort {
  private final TaskRepositoryMapper mapper;
  private final TaskRepository repository;

  public TaskRepositoryAdapter(TaskRepository repository, TaskRepositoryMapper mapper) {
    super(repository, mapper);
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public List<Task> getAll() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    return mapper.toDomainList(repository.findByUserEmail(userEmail));
  }

  @Override
  public void delete(String s) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    repository.deleteByUserEmail(userEmail);
  }

  @Override
  public Optional<Task> findById(String id) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    return mapper.toDomain(repository.findByIdAndUserEmail(id, userEmail));
  }
}
