package com.projects.taskmanager.task.adapters.controllers;

import com.projects.taskmanager.core.adapters.controllers.ControllerAdapter;
import com.projects.taskmanager.task.adapters.mappers.TaskControllerMapper;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.domain.ports.ITaskControllerPort;
import com.projects.taskmanager.task.domain.usecases.CreateTaskService;
import com.projects.taskmanager.task.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.task.domain.usecases.FindTaskService;
import com.projects.taskmanager.task.domain.usecases.UpdateTaskService;
import com.projects.taskmanager.task.infrastructure.dtos.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskControllerAdapter extends ControllerAdapter<Task, TaskDto, String> implements ITaskControllerPort {

  public TaskControllerAdapter(
    CreateTaskService createService,
    UpdateTaskService updateService,
    FindTaskService findService,
    DeleteTaskService deleteService,
    TaskControllerMapper mapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
  }
}
