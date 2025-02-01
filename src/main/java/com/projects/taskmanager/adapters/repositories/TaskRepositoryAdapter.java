package com.projects.taskmanager.adapters.repositories;

import com.projects.taskmanager.adapters.mappers.TaskRepositoryMapper;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskRepositoryPort;
import com.projects.taskmanager.infraestructure.repositories.TaskRepository;
import com.projects.taskmanager.infraestructure.repositories.entities.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TaskRepositoryAdapter implements ITaskRepositoryPort<Task> {
  private final TaskRepository repository;
  private final TaskRepositoryMapper mapper;

  @Override
  public Task create(Task task) {
    TaskEntity entity = mapper.toEntity(task);
    TaskEntity created = repository.save(entity);
    return mapper.toDomain(created);
  }

  @Override
  public List<Task> getAll() {
    List<TaskEntity> tasks = repository.findAll();
    return mapper.toDomainList(tasks);
  }

  @Override
  public void delete(String id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<Task> findById(String id) {
    Optional<TaskEntity> entity = repository.findById(id);
    return mapper.toDomain(entity);
  }
}
