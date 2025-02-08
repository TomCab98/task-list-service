package com.projects.taskmanager.core.adapters.controllers;

import com.projects.taskmanager.core.adapters.mappers.ControllerMapper;
import com.projects.taskmanager.core.domain.ports.IControllerPort;
import com.projects.taskmanager.core.domain.usecases.impl.CreateService;
import com.projects.taskmanager.core.domain.usecases.impl.DeleteService;
import com.projects.taskmanager.core.domain.usecases.impl.FindService;
import com.projects.taskmanager.core.domain.usecases.impl.UpdateService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ControllerAdapter<M, D, ID> implements IControllerPort<D, ID> {
  private final CreateService<M, ID> createService;
  private final UpdateService<M, ID> updateService;
  private final FindService<M, ID> findService;
  private final DeleteService<M, ID> deleteService;
  private final ControllerMapper<M, D> mapper;

  @Override
  public D create(D dto) {
    M domain = mapper.toDomain(dto);
    M created = createService.create(domain);
    return mapper.toDto(created);
  }

  @Override
  public List<D> getAll() {
    List<M> domains = findService.findAll();
    return mapper.toDtoList(domains);
  }

  @Override
  public D update(ID id, D criteria) {
    M partial = mapper.toDomain(criteria);
    M updated = updateService.update(id, partial);
    return mapper.toDto(updated);
  }

  @Override
  public void delete(ID id) {
    deleteService.delete(id);
  }

  @Override
  public D findById(ID id) {
    M domain = findService.findById(id);
    return mapper.toDto(domain);
  }
}
