package com.projects.taskmanager.core.domain.usecases.impl;

import com.projects.taskmanager.core.domain.exceptions.DatabaseAccessException;
import com.projects.taskmanager.core.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.IDeleteService;

public class DeleteService<M, ID> implements IDeleteService<ID> {
  private final IRepositoryPort<M, ID> repository;
  private final FindService<M, ID> findService;

  public DeleteService(IRepositoryPort<M, ID> repository, FindService<M, ID> findService) {
    this.repository = repository;
    this.findService = findService;
  }

  @Override
  public void delete(ID id) {
    if (!findService.existById(id)) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    try {
      this.repository.delete(id);
    } catch (Exception e) {
      throw new DatabaseAccessException("Fail deleting the task from database " + id);
    }

  }
}
