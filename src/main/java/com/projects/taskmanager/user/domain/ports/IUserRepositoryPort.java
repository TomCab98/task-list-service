package com.projects.taskmanager.user.domain.ports;

import com.projects.taskmanager.core.domain.ports.IRepositoryPort;
import com.projects.taskmanager.user.domain.models.User;

public interface IUserRepositoryPort extends IRepositoryPort<User, String> {}
