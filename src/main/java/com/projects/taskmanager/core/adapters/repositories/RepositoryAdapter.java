package com.projects.taskmanager.core.adapters.repositories;

import com.projects.taskmanager.core.adapters.mappers.RepositoryMapper;
import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.core.infraestructure.repositories.IRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RepositoryAdapter<M, E, ID> implements IRepositoryPort<M, ID> {
  private final IRepository<E, ID> repository;
  private final RepositoryMapper<M, E> mapper;

  @Override
  public M create(M domain) {
    E entity = mapper.toEntity(domain);
    E created = repository.save(entity);
    return mapper.toDomain(created);
  }

  @Override
  public List<M> getAll() {
    List<E> domains = repository.findAll();
    return mapper.toDomainList(domains);
  }

  @Override
  public void delete(ID id) {
    repository.deleteById(id);
  }

  @Override
  public Optional<M> findById(ID id) {
    Optional<E> entity = repository.findById(id);
    return mapper.toDomain(entity);
  }
}
