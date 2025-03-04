package com.projects.taskmanager.core.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<A, ID> extends JpaRepository<A, ID> {}
