package com.projects.taskmanager.core.adapters.mappers;

import java.util.List;
import java.util.Optional;

public interface RepositoryMapper<M, E> {
  E toEntity(M model);

  M toDomain(E entity);

  List<M> toDomainList(List<E> entities);

  default Optional<M> toDomain(Optional<E> entity) {
    return entity.map(this::toDomain);
  }
}
