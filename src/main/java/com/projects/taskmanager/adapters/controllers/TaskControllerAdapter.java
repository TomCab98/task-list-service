package com.projects.taskmanager.adapters.controllers;

import com.projects.taskmanager.adapters.mappers.TaskControllerMapper;
import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskServicePort;
import com.projects.taskmanager.domain.usecases.CreateTaskService;
import com.projects.taskmanager.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.domain.usecases.FindTaskService;
import com.projects.taskmanager.domain.usecases.UpdateTaskService;
import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskControllerAdapter implements ITaskServicePort<TaskDto> {
  private final TaskRepositoryAdapter repository;
  private final CreateTaskService createTaskService;
  private final UpdateTaskService updateTaskService;
  private final FindTaskService findTaskService;
  private final DeleteTaskService deleteTaskService;

  @Autowired
  public TaskControllerAdapter(TaskRepositoryAdapter repository) {
    this.repository = repository;
    this.createTaskService = new CreateTaskService(repository);
    this.deleteTaskService = new DeleteTaskService(repository);
    this.findTaskService = new FindTaskService(repository);
    this.updateTaskService = new UpdateTaskService(repository);
  }

  @Override
  public TaskDto createTask(TaskDto dto) {
    Task created = this.createTaskService.create(TaskControllerMapper.INSTANCE.toDomain(dto));
    return TaskControllerMapper.INSTANCE.toDto(created);
  }

  @Override
  public List<TaskDto> getAllTasks() {
    List<Task> tasks = this.findTaskService.findAll();
    return tasks.stream().map(TaskControllerMapper.INSTANCE::toDto).toList();
  }

  @Override
  public TaskDto updateTask(String id, TaskDto task) {
    return null;
  }

  @Override
  public void deleteTask(String id) {
    this.deleteTaskService.delete(id);
  }

}
