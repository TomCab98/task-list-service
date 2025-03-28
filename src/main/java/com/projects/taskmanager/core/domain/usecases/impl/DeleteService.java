package com.projects.taskmanager.core.domain.usecases.impl;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.IDeleteService;
import org.springframework.transaction.annotation.Transactional;

public class DeleteService<M, ID> implements IDeleteService<ID> {
  private final IRepositoryPort<M, ID> repository;
  private final FindService<M, ID> findService;

  public DeleteService(IRepositoryPort<M, ID> repository, FindService<M, ID> findService) {
    this.repository = repository;
    this.findService = findService;
  }

  @Override
  @Transactional
  public void delete(ID id) {
    if (!findService.existById(id)) {
      throw new NotFoundException("Not found task with id " + id);
    }

    try {
      this.repository.delete(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail deleting the domain from database " + id + e.getMessage());
    }

  }
}
