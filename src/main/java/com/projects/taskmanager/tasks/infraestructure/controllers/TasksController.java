package com.projects.taskmanager.tasks.infraestructure.controllers;

import com.projects.taskmanager.core.infraestructure.controllers.CoreController;
import com.projects.taskmanager.tasks.adapters.controllers.TaskControllerAdapter;
import com.projects.taskmanager.tasks.domain.models.Task;
import com.projects.taskmanager.tasks.infraestructure.dtos.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
public class TasksController extends CoreController<Task, TaskDto, String> {

  public TasksController(TaskControllerAdapter adapter) {
    super(adapter);
  }
}
