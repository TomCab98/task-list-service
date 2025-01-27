package com.projects.taskmanager.adapters.repositories;

import com.projects.taskmanager.adapters.mappers.TaskRepositoryMapper;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskServicePort;
import com.projects.taskmanager.infraestructure.repositories.TaskRepository;
import com.projects.taskmanager.infraestructure.repositories.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskRepositoryAdapter implements ITaskServicePort<Task> {

  @Autowired
  private TaskRepository repository;

  @Override
  public Task createTask(Task task) {
    TaskEntity created = this.repository.save(TaskRepositoryMapper.INSTANCE.toEntity(task));
    return TaskRepositoryMapper.INSTANCE.toDomain(created);
  }

  @Override
  public List<Task> getAllTasks() {
    return this.repository.findAll().stream().map(TaskRepositoryMapper.INSTANCE::toDomain).toList();
  }

  @Override
  public Task updateTask(String id, Task task) {
    return null;
  }

  @Override
  public void deleteTask(String id) {
    this.repository.deleteById(id);
  }
}
