package com.projects.taskmanager.user.infrastructure.controllers;

import com.projects.taskmanager.user.infrastructure.dtos.AuthRequestDto;
import com.projects.taskmanager.user.infrastructure.dtos.AuthResponseDto;
import com.projects.taskmanager.user.infrastructure.security.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserDetailServiceImpl userDetailService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid AuthRequestDto userRequest) {
    return new ResponseEntity<>(this.userDetailService.login(userRequest), HttpStatus.OK);
  }
}
