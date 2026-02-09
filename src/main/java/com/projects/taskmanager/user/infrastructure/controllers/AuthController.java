package com.projects.taskmanager.user.infrastructure.controllers;

import com.projects.taskmanager.user.adapters.auth.UserAuthAdapter;
import com.projects.taskmanager.user.infrastructure.dtos.LoginRequestDto;
import com.projects.taskmanager.user.infrastructure.dtos.LoginResponseDto;
import com.projects.taskmanager.user.infrastructure.dtos.UserDto;
import com.projects.taskmanager.user.infrastructure.security.UserDetailServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserDetailServiceImpl userDetailService;
  private final UserAuthAdapter userAuthAdapter;

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto userRequest) {
    return new ResponseEntity<>(this.userDetailService.login(userRequest), HttpStatus.OK);
  }

  @PostMapping("/register")
  public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userRequest) {
    UserDto user = userAuthAdapter.createUser(userRequest);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(user.getId()).toUri();

    return ResponseEntity.created(location).build();
  }
}
