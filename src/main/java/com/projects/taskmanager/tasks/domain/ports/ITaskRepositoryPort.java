package com.projects.taskmanager.tasks.domain.ports;

import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.tasks.domain.models.Task;

public interface ITaskRepositoryPort extends IRepositoryPort<Task, String> {}
