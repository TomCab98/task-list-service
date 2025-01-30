package com.projects.taskmanager.adapters.controllers;

import com.projects.taskmanager.adapters.mappers.TaskControllerMapper;
import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.exceptions.MappingException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskControllerPort;
import com.projects.taskmanager.domain.usecases.CreateTaskService;
import com.projects.taskmanager.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.domain.usecases.FindTaskService;
import com.projects.taskmanager.domain.usecases.UpdateTaskService;
import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskControllerAdapter implements ITaskControllerPort<TaskDto> {

  @Autowired
  private TaskRepositoryAdapter repository;

  @Autowired
  private CreateTaskService createTaskService;

  @Autowired
  private UpdateTaskService updateTaskService;

  @Autowired
  private FindTaskService findTaskService;

  @Autowired
  private DeleteTaskService deleteTaskService;

  @Override
  public TaskDto create(TaskDto dto) {
    Task domain;
    try {
      domain = TaskControllerMapper.INSTANCE.toDomain(dto);
    } catch (Exception e) {
      throw new MappingException("Error trying to map Taskdto to Task " + dto.toString());
    }

    Task taskCreated = this.createTaskService.create(domain);

    TaskDto response;
    try {
      response = TaskControllerMapper.INSTANCE.toDto(taskCreated);
    } catch (Exception e) {
      throw new MappingException("Error trying to map Task to TaskDto " + taskCreated.toString());
    }

    return response;
  }

  @Override
  public List<TaskDto> getAll() {
    List<Task> tasks = this.findTaskService.findAll();

    List<TaskDto> dtos;
    try {
      dtos = tasks.stream().map(TaskControllerMapper.INSTANCE::toDto).toList();
    } catch (Exception e) {
      throw new MappingException("Error trying to map the task list " + tasks.toString());
    }
    return dtos;
  }

  @Override
  public TaskDto update(String id, TaskDto criteria) {
    Task partial;
    try {
      partial = TaskControllerMapper.INSTANCE.toDomain(criteria);
    } catch (Exception e) {
      throw new MappingException("Error trying to map TaskDto to Task " + criteria.toString());
    }

    Task updated = this.updateTaskService.update(id, partial);

    TaskDto response;
    try {
      response = TaskControllerMapper.INSTANCE.toDto(updated);
    } catch (Exception e) {
      throw new MappingException("Erro trying to map Task to TaskDto " + updated.toString());
    }

    return response;
  }

  @Override
  public void delete(String id) {
    this.deleteTaskService.delete(id);
  }

  @Override
  public TaskDto findById(String id) {
    Task task = this.findTaskService.findById(id);

    TaskDto dto;
    try {
      dto = TaskControllerMapper.INSTANCE.toDto(task);
    } catch (Exception e) {
      throw new MappingException("Error trying to map Task to Taskdto " + task.toString());
    }

    return dto;
  }

}
