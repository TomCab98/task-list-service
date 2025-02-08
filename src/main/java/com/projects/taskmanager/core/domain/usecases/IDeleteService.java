package com.projects.taskmanager.core.domain.usecases;

public interface IDeleteService<ID> {
  public void delete(ID id);
}
