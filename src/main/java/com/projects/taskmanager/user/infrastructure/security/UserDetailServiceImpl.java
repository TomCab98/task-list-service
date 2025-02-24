package com.projects.taskmanager.user.infrastructure.security;

import com.projects.taskmanager.core.domain.exceptions.NotFoundException;
import com.projects.taskmanager.user.infrastructure.repositories.UserRepository;
import com.projects.taskmanager.user.infrastructure.repositories.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) {

    UserEntity userEntity = repository.findUserEntityByUsername(username)
      .orElseThrow(() -> new NotFoundException("user not found"));

    List<SimpleGrantedAuthority> grantedAuthorityList = new ArrayList<>();

    userEntity.getRoles()
      .forEach(role -> grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()))));

    userEntity.getRoles()
      .stream()
      .flatMap(role -> role.getPermissionList().stream())
      .forEach(permission -> grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getPermission().name())));

    return new User(
      userEntity.getUsername(),
      userEntity.getPassword(),
      userEntity.isEnabled(),
      userEntity.isAccountNoExpired(),
      userEntity.isCredentialsNoExpired(),
      userEntity.isAccountNoLocked(),
      grantedAuthorityList
    );
  }
}
