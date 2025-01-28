package com.projects.taskmanager.adapters.controllers;

import com.projects.taskmanager.adapters.mappers.TaskControllerMapper;
import com.projects.taskmanager.adapters.repositories.TaskRepositoryAdapter;
import com.projects.taskmanager.domain.exceptions.MappingException;
import com.projects.taskmanager.domain.models.Task;
import com.projects.taskmanager.domain.ports.ITaskServicePort;
import com.projects.taskmanager.domain.usecases.CreateTaskService;
import com.projects.taskmanager.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.domain.usecases.FindTaskService;
import com.projects.taskmanager.domain.usecases.UpdateTaskService;
import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskControllerAdapter implements ITaskServicePort<TaskDto> {

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
  public TaskDto createTask(TaskDto dto) {
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
  public List<TaskDto> getAllTasks() {
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
  public TaskDto updateTask(String id, TaskDto task) {
    return null;
  }

  @Override
  public void deleteTask(String id) {
    this.deleteTaskService.delete(id);
  }

}
