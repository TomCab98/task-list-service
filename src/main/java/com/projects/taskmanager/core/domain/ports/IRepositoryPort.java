package com.projects.taskmanager.core.domain.ports;

import java.util.List;
import java.util.Optional;

public interface IRepositoryPort<M, ID> {
  M create(M task);

  List<M> getAll();

  void delete(ID id);

  Optional<M> findById(ID id);
}
