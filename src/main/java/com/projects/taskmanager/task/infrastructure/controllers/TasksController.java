package com.projects.taskmanager.task.infrastructure.controllers;

import com.projects.taskmanager.core.infrastructure.controllers.CoreController;
import com.projects.taskmanager.task.adapters.controllers.TaskControllerAdapter;
import com.projects.taskmanager.task.domain.models.Task;
import com.projects.taskmanager.task.infrastructure.dtos.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class  TasksController extends CoreController<Task, TaskDto, String> {

  public TasksController(TaskControllerAdapter adapter) {
    super(adapter);
  }

  @Override
  public ResponseEntity<TaskDto> create(TaskDto dto) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();
    dto.setUserEmail(userEmail);

    return super.create(dto);
  }
}
