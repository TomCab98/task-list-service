package com.projects.taskmanager.domain.ports;

import java.util.List;
import java.util.Optional;

public interface ITaskRepositoryPort<MODEL> {
  MODEL create(MODEL task);

  List<MODEL> getAll();

  void delete(String id);

  Optional<MODEL> findById(String id);
}
