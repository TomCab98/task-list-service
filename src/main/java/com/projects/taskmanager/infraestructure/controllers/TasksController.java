package com.projects.taskmanager.infraestructure.controllers;

import com.projects.taskmanager.adapters.controllers.TaskControllerAdapter;
import com.projects.taskmanager.infraestructure.dtos.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

  @Autowired
  private TaskControllerAdapter adapter;

  @PostMapping
  public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto dto) {
    return ResponseEntity.ok(this.adapter.create(dto));
  }

  @GetMapping
  public List<TaskDto> getAllTasks() {
    return this.adapter.getAll();
  }

  @GetMapping("/{id}")
  public TaskDto findById(@PathVariable String id) {
    return this.adapter.findById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TaskDto> updateTask(@PathVariable String id, @RequestBody TaskDto task) {
    return ResponseEntity.ok(this.adapter.update(id, task));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTask(@PathVariable String id) {
    this.adapter.delete(id);
    return ResponseEntity.noContent().build();
  }
}
