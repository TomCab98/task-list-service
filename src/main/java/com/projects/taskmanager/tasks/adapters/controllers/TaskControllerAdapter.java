package com.projects.taskmanager.tasks.adapters.controllers;

import com.projects.taskmanager.core.adapters.controllers.ControllerAdapter;
import com.projects.taskmanager.tasks.adapters.mappers.TaskControllerMapper;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.domain.ports.ITaskControllerPort;
import com.projects.taskmanager.tasks.domain.usecases.CreateTaskService;
import com.projects.taskmanager.tasks.domain.usecases.DeleteTaskService;
import com.projects.taskmanager.tasks.domain.usecases.FindTaskService;
import com.projects.taskmanager.tasks.domain.usecases.UpdateTaskService;
import com.projects.taskmanager.tasks.infrastructure.dtos.TaskDto;
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
