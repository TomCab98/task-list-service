package com.projects.taskmanager.infraestructure.controllers;

import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

  @PostMapping
  public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task) {
    return ResponseEntity.ok(task);
  }

  @GetMapping
  public List<TaskDto> getAllTasks() {
    return null;
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskDto> updateTask(
    @PathVariable String id,
    @RequestBody TaskDto task
  ) {
    return ResponseEntity.ok(task);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable String id) {
    return ResponseEntity.noContent().build();
  }
}
