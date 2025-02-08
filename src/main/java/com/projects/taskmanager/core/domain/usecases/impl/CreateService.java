package com.projects.taskmanager.core.domain.usecases.impl;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.ICreateService;

public class CreateService<M, ID> implements ICreateService<M> {
  private final IRepositoryPort<M, ID> repository;

  public CreateService(IRepositoryPort<M, ID> repository) {
    this.repository = repository;
  }

  @Override
  public M create(M model) {
    try {
      return repository.create(model);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail saving in database " + model.toString());
    }
  }
}
