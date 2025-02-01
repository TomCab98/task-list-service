package com.projects.taskmanager.adapters.controllers;

import com.projects.taskmanager.adapters.mappers.TaskControllerMapper;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskControllerPort;
import com.projects.taskmanager.domain.usecases.CreateTaskService;
import com.projects.taskmanager.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.domain.usecases.FindTaskService;
import com.projects.taskmanager.domain.usecases.UpdateTaskService;
import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TaskControllerAdapter implements ITaskControllerPort<TaskDto> {
  private final CreateTaskService createTaskService;
  private final UpdateTaskService updateTaskService;
  private final FindTaskService findTaskService;
  private final DeleteTaskService deleteTaskService;
  private final TaskControllerMapper mapper;

  @Override
  public TaskDto create(TaskDto dto) {
    Task task = mapper.toDomain(dto);
    Task taskCreated = createTaskService.create(task);
    return mapper.toDto(taskCreated);
  }

  @Override
  public List<TaskDto> getAll() {
    List<Task> tasks = findTaskService.findAll();
    return mapper.toDtoList(tasks);
  }

  @Override
  public TaskDto update(String id, TaskDto criteria) {
    Task partial = mapper.toDomain(criteria);
    Task updated = updateTaskService.update(id, partial);
    return mapper.toDto(updated);
  }

  @Override
  public void delete(String id) {
    deleteTaskService.delete(id);
  }

  @Override
  public TaskDto findById(String id) {
    Task task = findTaskService.findById(id);
    return mapper.toDto(task);
  }
}
