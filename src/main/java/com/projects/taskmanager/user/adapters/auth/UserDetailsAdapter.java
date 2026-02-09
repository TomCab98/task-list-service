package com.projects.taskmanager.user.adapters.auth;

import com.projects.taskmanager.user.infrastructure.security.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDetailsAdapter {

  private final UserDetailServiceImpl userDetailService;

  public String encodePassword(String password) {
    return userDetailService.encodePassword(password);
  }
}
