package com.projects.taskmanager.core.domain.ports;

import java.util.List;

public interface IControllerPort<D, ID> {
  D create(D task);

  List<D> getAll();

  D update(ID id, D partial);

  void delete(ID id);

  D findById(ID id);
}
