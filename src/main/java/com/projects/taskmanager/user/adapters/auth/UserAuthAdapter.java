package com.projects.taskmanager.user.adapters.auth;

import com.projects.taskmanager.user.infrastructure.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthAdapter {

  @Autowired
  private UserDetailServiceImpl userDetailService;

  public String encodePassword(String password) {
    return userDetailService.encodePassword(password);
  }
}
