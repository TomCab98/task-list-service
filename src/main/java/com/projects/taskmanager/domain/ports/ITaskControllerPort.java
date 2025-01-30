package com.projects.taskmanager.domain.ports;

import java.util.List;

public interface ITaskControllerPort<MODEL> {
  MODEL create(MODEL task);

  List<MODEL> getAll();

  MODEL update(String id, MODEL partial);

  void delete(String id);

  MODEL findById(String id);
}
