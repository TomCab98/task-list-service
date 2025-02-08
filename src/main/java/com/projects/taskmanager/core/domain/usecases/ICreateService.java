package com.projects.taskmanager.core.domain.usecases;

public interface ICreateService<M> {
  public M create(M model);
}
