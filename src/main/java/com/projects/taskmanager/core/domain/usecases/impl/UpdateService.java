package com.projects.taskmanager.core.domain.usecases.impl;

import com.projects.taskmanager.core.domain.exceptions.IllegalArgumentException;
import com.projects.taskmanager.core.domain.exceptions.TicketNotFoundException;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.domain.usecases.IUpdateService;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;

public class UpdateService<M, ID> implements IUpdateService<M, ID> {
  private final IRepositoryPort<M, ID> repository;

  public UpdateService(IRepositoryPort<M, ID> repository) {
    this.repository = repository;
  }

  @Override
  public M update(ID id, M criteria) {
    Optional<M> existModel = repository.findById(id);
    if (existModel.isEmpty()) {
      throw new TicketNotFoundException("Not found task with id " + id);
    }

    M model = existModel.get();
    for (Field field : criteria.getClass().getDeclaredFields()) {
      field.setAccessible(true);

      try {
        Object newValue = field.get(criteria);
        Object oldValue = field.get(model);

        if (newValue != null && !Objects.equals(newValue, oldValue)) {
          field.set(model, newValue);
        }
      } catch (Exception e) {
        throw new IllegalArgumentException("Error updating model field: " + field.getName() + e);
      }
    }

    return this.repository.create(model);
  }
}
