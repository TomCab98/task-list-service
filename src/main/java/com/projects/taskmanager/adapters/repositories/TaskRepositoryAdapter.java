package com.projects.taskmanager.adapters.repositories;

import com.projects.taskmanager.adapters.mappers.TaskRepositoryMapper;
import com.projects.taskmanager.domain.exceptions.MappingException;
import com.projects.taskmanager.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskServicePort;
import com.projects.taskmanager.infraestructure.repositories.TaskRepository;
import com.projects.taskmanager.infraestructure.repositories.entities.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryAdapter implements ITaskServicePort<Task> {

  @Autowired
  private TaskRepository repository;

  @Override
  public Task createTask(Task task) {
    TaskEntity entity;
    try {
      entity = TaskRepositoryMapper.INSTANCE.toEntity(task);
    } catch (Exception e) {
      throw new MappingException("Error trying to map Task to EntityTask " + task.toString());
    }

    TaskEntity created = this.repository.save(entity);

    Task response;
    try {
      response = TaskRepositoryMapper.INSTANCE.toDomain(created);
    } catch (Exception e) {
      throw new MappingException("Error trying to map EntityTask to Task " + created.toString());
    }

    return response;
  }

  @Override
  public List<Task> getAllTasks() {
    List<TaskEntity> entities = this.repository.findAll();

    List<Task> tasks;
    try {
      tasks = entities.stream().map(TaskRepositoryMapper.INSTANCE::toDomain).toList();
    } catch (Exception e) {
      throw new MappingException("Error trying to map the task list " + entities);
    }

    return tasks;
  }

  @Override
  public Task updateTask(String id, Task task) {
    return null;
  }

  @Override
  public void deleteTask(String id) {
    this.repository.deleteById(id);
  }

  @Override
  public Task findById(String id) {
    Optional<TaskEntity> entity = this.repository.findById(id);
    if (entity.isEmpty()) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    Task task;
    try {
      task = TaskRepositoryMapper.INSTANCE.toDomain(entity.get());
    } catch (Exception e) {
      throw new MappingException("Error trying to map TaskEntity to Task");
    }

    return task;
  }
}
