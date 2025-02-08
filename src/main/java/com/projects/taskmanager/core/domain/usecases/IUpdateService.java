package com.projects.taskmanager.core.domain.usecases;

public interface IUpdateService<M, ID> {
  public M update(ID id, M criteria);
}
