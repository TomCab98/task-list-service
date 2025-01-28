package com.projects.taskmanager.domain.ports;

import java.util.List;

public interface ITaskServicePort<MODEL> {
  MODEL createTask(MODEL task);

  List<MODEL> getAllTasks();

  MODEL updateTask(String id, MODEL task);

  void deleteTask(String id);

  MODEL findById(String id);
}
