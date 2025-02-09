package com.projects.taskmanager.user.domain.ports;

import com.projects.taskmanager.core.domain.ports.IControllerPort;
import com.projects.taskmanager.user.infraestructure.dtos.UserDto;

public interface IUserControllerPort extends IControllerPort<UserDto, String> {}
