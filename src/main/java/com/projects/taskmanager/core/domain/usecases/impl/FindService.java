package com.projects.taskmanager.core.domain.usecases.impl;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.IFindService;

import java.util.List;
import java.util.Optional;

public class FindService<M, ID> implements IFindService<M, ID> {
  private final IRepositoryPort<M, ID> repository;

  public FindService(IRepositoryPort<M, ID> repository) {
    this.repository = repository;
  }

  @Override
  public List<M> findAll() {
    try {
      return this.repository.getAll();
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining domain from database" + e.getMessage());
    }
  }

  @Override
  public M findById(ID id) {
    Optional<M> domain;
    try {
      domain = this.repository.findById(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail obtaining domain with id from database" + e.getMessage());
    }

    if (domain.isEmpty()) {
      throw new NotFoundException("Not found domain with id " + id);
    }

    return domain.get();
  }

  @Override
  public boolean existById(ID id) {
    Optional<M> task = this.repository.findById(id);
    return task.isPresent();
  }
}
