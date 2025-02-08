package com.projects.taskmanager.core.domain.usecases;

import java.util.List;

public interface IFindService<M, ID> {
  public List<M> findAll();

  public M findById(ID id);

  public boolean existById(ID id);
}
