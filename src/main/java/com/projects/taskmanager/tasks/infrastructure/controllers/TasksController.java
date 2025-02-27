package com.projects.taskmanager.tasks.infrastructure.controllers;

import com.projects.taskmanager.core.infrastructure.controllers.CoreController;
import com.projects.taskmanager.tasks.adapters.controllers.TaskControllerAdapter;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.infrastructure.dtos.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TasksController extends CoreController<Task, TaskDto, String> {

  public TasksController(TaskControllerAdapter adapter) {
    super(adapter);
  }
}
